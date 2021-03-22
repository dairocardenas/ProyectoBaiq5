/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.facade;

import edu.proyectobaiq5.entity.TarjetaPuntos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daniela
 */
@Local
public interface TarjetaPuntosFacadeLocal {

    void create(TarjetaPuntos tarjetaPuntos);

    void edit(TarjetaPuntos tarjetaPuntos);

    void remove(TarjetaPuntos tarjetaPuntos);

    TarjetaPuntos find(Object id);

    List<TarjetaPuntos> findAll();

    List<TarjetaPuntos> findRange(int[] range);

    int count();
    
}
