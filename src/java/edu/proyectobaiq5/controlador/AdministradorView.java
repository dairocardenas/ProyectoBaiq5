/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.controlador;

import edu.proyectobaiq5.entity.Usuario;
import edu.proyectobaiq5.facade.UsuarioFacadeLocal;
import edu.proyectobaiq5.utilidades.Email;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Usuario
 */
@Named(value = "administradorView")
@ViewScoped
public class AdministradorView implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private Usuario usReg = new Usuario();
    
    @Inject
    UsuarioSession usuarioSession;
    
    
    /**
     * Creates a new instance of AdministradorView
     */
    @PostConstruct
    public void leerListaUsuarios() {
        listaUsuarios.addAll(usuarioFacadeLocal.findAll());
    }
   

    public void crearUsuario() {
        String mensajeSw = "";
        try {
            usReg.setFechaNacimiento(new Date());
            usuarioFacadeLocal.create(usReg);
            listaUsuarios.add(usReg);
            mensajeSw = "swal('Usuario registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El usuario' , ' Ya se encuentra registrado  ', 'error')";
        }
        usReg = new Usuario();
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void removerUsuario(Usuario usuRem) {
        String mensajeSw = "";
        try {
            usuarioFacadeLocal.remove(usuRem);
            listaUsuarios.remove(usuRem);
            mensajeSw = "swal('Usuario removido' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas removiendo' , ' al usuario  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void cargaUsuarioEditar(Usuario usuEditar) {
        this.usReg = usuEditar;
    }

    public void editarUsuario() {
        String mensajeSw = "";
        try {
            usuarioFacadeLocal.edit(usReg);
            listaUsuarios.clear();
            listaUsuarios.addAll(usuarioFacadeLocal.findAll());
            mensajeSw = "swal('Usuario modificado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas modificando' , ' al usuario  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void correoMasivo() {
        try {
            for (Usuario lUsuario : listaUsuarios) {
                Email.sendBienvenido(lUsuario.getCorreoElectronico(),
                        lUsuario.getPrimerNombre()+ " " + lUsuario.getPrimerApellido(),
                        lUsuario.getCorreoElectronico(), lUsuario.getPassword());
            }
        } catch (Exception e) {
        }

    }
    
    
    public void descargaCertificado(String idUsuario)  {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();

        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("application/pdf");

        try {
            Map parametro = new HashMap(); 
            parametro.put("idUsuario", idUsuario);
            parametro.put("RutaImagen", context.getRealPath("/images/senaFondo.jpg"));
            Connection conec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dashio", "root", "root");
            System.out.println("Catalogo : " + conec.getCatalog());
            
            File jasper = new File(context.getRealPath("/WEB-INF/classes/edu/webapp1966781a/reportes/certificado.jasper"));
             
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametro, conec);
            
            HttpServletResponse hsr = (HttpServletResponse) context.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Certificado.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            facesContext.responseComplete();
           
        } catch (JRException e) {
            System.out.println("edu.webapp1966781a.controlador.AdministradorView.descargaReporte() " + e.getMessage());
        } catch(IOException i){
            System.out.println("edu.webapp1966781a.controlador.AdministradorView.descargaReporte() " + i.getMessage());
        } catch (SQLException q){
            System.out.println("edu.webapp1966781a.controlador.AdministradorView.descargaReporte() " + q.getMessage());
        }

    }
     

    public void descargaReporte(String nombreReporte)  {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();

        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("application/pdf");

        try {
            Map parametro = new HashMap();
            parametro.put("Empresa", "BAIQ");
            parametro.put("UsuarioReporte", usuarioSession.getUsuLogin().getPrimerNombre()+ " " + usuarioSession.getUsuLogin().getPrimerApellido());
            parametro.put("RutaImagen", context.getRealPath("/images/principal.jpg"));
            Connection conec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/baiq4", "root", "");
            System.out.println("Catalogo : " + conec.getCatalog());
            
            File jasper = new File(context.getRealPath("/WEB-INF/classes/edu/proyectobaiq5/reportes/"+nombreReporte+".jasper"));
             
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametro, conec);
            
            HttpServletResponse hsr = (HttpServletResponse) context.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Lista Usuarios.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            facesContext.responseComplete();
           
        } catch (JRException e) {
            System.out.println("edu.proyectobaiq5.controlador.AdministradorView.descargaReporte() " + e.getMessage());
        } catch(IOException i){
            System.out.println("edu.proyectobaiq5.controlador.AdministradorView.descargaReporte() " + i.getMessage());
        } catch (SQLException q){
            System.out.println("edu.proyectobaiq5.controlador.AdministradorView.descargaReporte() " + q.getMessage());
        }

    }

    public AdministradorView() {
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsReg() {
        return usReg;
    }

    public void setUsReg(Usuario usReg) {
        this.usReg = usReg;
    }

}

