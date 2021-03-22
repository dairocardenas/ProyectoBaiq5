/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.facade;

import edu.proyectobaiq5.entity.Fidelizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daniela
 */
@Local
public interface FidelizacionFacadeLocal {

    void create(Fidelizacion fidelizacion);

    void edit(Fidelizacion fidelizacion);

    void remove(Fidelizacion fidelizacion);

    Fidelizacion find(Object id);

    List<Fidelizacion> findAll();

    List<Fidelizacion> findRange(int[] range);

    int count();
    
}
