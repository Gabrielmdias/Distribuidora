/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidoraDAO;

import connectionDB.ConnectionDB;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.EntidadeBase;

/**
 *
 * @author Gabriel
 * @param <E>
 */
public class GenericDAO<E extends EntidadeBase> {
    
    public void save(E entity){
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public void update(E entity) {
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public E find(Class<E> classe, Long id) {
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            return em.find(classe ,id);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return null;
    }
    
    public void remove(Class<E> classe, Long id) {
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            E e = em.find(classe, id);
            em.remove(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
