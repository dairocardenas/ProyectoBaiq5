/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.controlador;

import edu.proyectobaiq5.entity.Fidelizacion;
import edu.proyectobaiq5.facade.FidelizacionFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dairo
 */
@Named(value = "fidelizacionVIew")
@ViewScoped
public class FidelizacionVIew implements Serializable {

    @EJB
    FidelizacionFacadeLocal fidelizacionFacadeLocal;
    private ArrayList<Fidelizacion> listaFidelizacion= new ArrayList<>();
    
     @PostConstruct
    public void leerListaFidelizacion(){
        listaFidelizacion.addAll( fidelizacionFacadeLocal.findAll());
    }
    
    
    public FidelizacionVIew() {
    }

    public ArrayList<Fidelizacion> getListaFidelizacion() {
        return listaFidelizacion;
    }

    public void setListaFidelizacion(ArrayList<Fidelizacion> listaFidelizacion) {
        this.listaFidelizacion = listaFidelizacion;
    }
    
}
