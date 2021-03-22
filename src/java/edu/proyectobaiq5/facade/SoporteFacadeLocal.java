/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.facade;

import edu.proyectobaiq5.entity.Soporte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daniela
 */
@Local
public interface SoporteFacadeLocal {

    void create(Soporte soporte);

    void edit(Soporte soporte);

    void remove(Soporte soporte);

    Soporte find(Object id);

    List<Soporte> findAll();

    List<Soporte> findRange(int[] range);

    int count();
    
}
