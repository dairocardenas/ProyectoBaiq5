/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.controlador;

import edu.proyectobaiq5.entity.Usuario;
import edu.proyectobaiq5.facade.UsuarioFacadeLocal;
import edu.proyectobaiq5.utilidades.Email;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Daniela
 */
@Named(value = "usuarioRequest")
@RequestScoped
public class UsuarioRequest implements Serializable{
    
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
            
    private Usuario reg = new Usuario();
    private String correoRecuperar = "";
    
     public UsuarioRequest() {
    }
    
    /*public void registrarUsuario(){
        try {
            usuarioFacadeLocal.create(reg);
        } catch (Exception e) {
        }
    } */
    public void registrarUsuario() {
        String mensajeSw = "";
        try {
            reg.setFechaNacimiento(new Date());
            usuarioFacadeLocal.create(reg);
            mensajeSw = "swal('Usuario registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El usuario' , ' Ya se encuentra registrado  ', 'error')";
        }
        reg = new Usuario();
        PrimeFaces.current().executeScript(mensajeSw);
    }
    
    public void recuperarClave(){
        Usuario usuRecuperar = new Usuario();
        String mensajeSw = "";
        try {
             usuRecuperar = usuarioFacadeLocal.recuperarClave(correoRecuperar);
             if(usuRecuperar.getPrimerNombre()== null){
                  mensajeSw = "swal('El correo' , ' No se encuentra registrado  ', 'error')";
             }else{
                 
                    Email.sendClaves(usuRecuperar.getCorreoElectronico(), 
                                      usuRecuperar.getPrimerNombre()+" " + usuRecuperar.getPrimerApellido(),
                                      usuRecuperar.getCorreoElectronico(),
                                      usuRecuperar.getPassword());
                    
                  mensajeSw = "swal('La clave es enviada' , ' A su correo electronico  ', 'success')";
             }
        } catch (Exception e) {
            mensajeSw = "swal('El correo' , ' No se encuentra registrado  ', 'error')";
        }
             PrimeFaces.current().executeScript(mensajeSw);
    }

    /**
     * Creates a new instance of UsuarioRequest
     */
   

    public Usuario getReg() {
        return reg;
    }

    public void setReg(Usuario reg) {
        this.reg = reg;
    }
     public String getCorreoRecuperar() {
        return correoRecuperar;
    }

    public void setCorreoRecuperar(String correoRecuperar) {
        this.correoRecuperar = correoRecuperar;
    }

    
    
    
    
}
