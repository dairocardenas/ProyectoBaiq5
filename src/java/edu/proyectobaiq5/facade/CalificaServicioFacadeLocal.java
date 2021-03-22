/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.facade;

import edu.proyectobaiq5.entity.CalificaServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daniela
 */
@Local
public interface CalificaServicioFacadeLocal {

    void create(CalificaServicio calificaServicio);

    void edit(CalificaServicio calificaServicio);

    void remove(CalificaServicio calificaServicio);

    CalificaServicio find(Object id);

    List<CalificaServicio> findAll();

    List<CalificaServicio> findRange(int[] range);

    int count();
    
}
