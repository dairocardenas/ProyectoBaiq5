/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.controlador;

import edu.proyectobaiq5.entity.Sucursal;
import edu.proyectobaiq5.facade.SucursalFacadeLocal;
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
@Named(value = "sucusalesView")
@ViewScoped
public class SucusalesView implements Serializable{
    @EJB
    SucursalFacadeLocal sucursalFacadeLocal;
    private ArrayList<Sucursal> listaSucursales= new ArrayList<>();

    /**
     * Creates a new instance of SucusalesView
     */
    
    @PostConstruct
    public void leerListaSucursales(){
        listaSucursales.addAll( sucursalFacadeLocal.findAll());
    }
    public SucusalesView() {
    }

    public ArrayList<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(ArrayList<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }
    
}
