/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.facade;

import edu.proyectobaiq5.entity.OrdenServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daniela
 */
@Local
public interface OrdenServicioFacadeLocal {

    void create(OrdenServicio ordenServicio);

    void edit(OrdenServicio ordenServicio);

    void remove(OrdenServicio ordenServicio);

    OrdenServicio find(Object id);

    List<OrdenServicio> findAll();

    List<OrdenServicio> findRange(int[] range);

    int count();
    
}
