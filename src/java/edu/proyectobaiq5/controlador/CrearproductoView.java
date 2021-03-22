/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.controlador;

import edu.proyectobaiq5.entity.TipoProducto;
import edu.proyectobaiq5.facade.TipoProductoFacadeLocal;
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
@Named(value = "crearproductoView")
@ViewScoped
public class CrearproductoView implements Serializable{

    @EJB
    TipoProductoFacadeLocal tipoproductoFacadeLocal;
    private ArrayList<TipoProducto> listaProducto= new ArrayList<>();

    
    
    @PostConstruct
    public void leerListaProducto(){
        listaProducto.addAll( tipoproductoFacadeLocal.findAll());
    }
    public CrearproductoView() {
    }

    public ArrayList<TipoProducto> getListaProducto() {
        return listaProducto;
    }

    public void setListaTipoProducto(ArrayList<TipoProducto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
}
