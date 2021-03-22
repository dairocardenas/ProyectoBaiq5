/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.controlador;

import edu.proyectobaiq5.entity.DetalleOrdenPago;
import edu.proyectobaiq5.facade.DetalleOrdenPagoFacadeLocal;
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
@Named(value = "ordenPagoView")
@ViewScoped
public class OrdenPagoView implements Serializable {

    @EJB
    DetalleOrdenPagoFacadeLocal detalleordenpagoFacadeLocal;
    private ArrayList<DetalleOrdenPago> listaDetalleOrdenPago= new ArrayList<>();
    
     @PostConstruct
    public void leerListaDetalleOrdenPago(){
        listaDetalleOrdenPago.addAll( detalleordenpagoFacadeLocal.findAll());
    }
    
    
    public OrdenPagoView() {
    }

    public ArrayList<DetalleOrdenPago> getListaDetalleOrdenPago() {
        return listaDetalleOrdenPago;
    }

    public void setListaDetalleOrdenPago(ArrayList<DetalleOrdenPago> listaDetalleOrdenPago) {
        this.listaDetalleOrdenPago = listaDetalleOrdenPago;
    }
    
}
