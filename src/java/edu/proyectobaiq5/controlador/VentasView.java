/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.controlador;

import edu.proyectobaiq5.entity.Venta;
import edu.proyectobaiq5.facade.VentaFacadeLocal;
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
@Named(value = "ventasView")
@ViewScoped
public class VentasView implements Serializable{

     @EJB
    VentaFacadeLocal ventaFacadeLocal;
    private ArrayList<Venta> listaVenta= new ArrayList<>();
    
     @PostConstruct
    public void leerListaVenta(){
        listaVenta.addAll( ventaFacadeLocal.findAll());
    }
    
    
    
    
    public VentasView() {
    }
    
     public ArrayList<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(ArrayList<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }
    
    
}
