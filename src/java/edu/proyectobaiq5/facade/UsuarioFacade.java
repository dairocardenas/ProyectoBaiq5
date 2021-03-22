/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectobaiq5.facade;

import edu.proyectobaiq5.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniela
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProyectoBaiq5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
     @Override
    public Usuario recuperarClave( String correoIn){
        try {
           Query qt = em.createQuery("SELECT p FROM Usuario p WHERE p.correoElectronico = :correoIn");
           qt.setParameter("correoIn", correoIn);
           return  (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }        
    }
    @Override
    public Usuario loginUsuario( String correoElectronico , String password){
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico AND u.password = :password");
            q.setParameter("correoElectronico", correoElectronico);
            q.setParameter("password", password);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    } 
    
    @Override    
    public Usuario usurol( int rol){
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u inner join  WHERE u.idrol = :idrol");
            q.setParameter("idrol", rol);         
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    } 

   
    
}
