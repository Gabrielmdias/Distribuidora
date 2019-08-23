/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidoraDAO;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Usuario;
import connectionDB.ConnectionDB;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO {

    public void save(Usuario usuario) {
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void update(Usuario usuario) {
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Usuario find(long id) {
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            return em.find(Usuario.class, id);
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Usuario não encontrado. " +e.toString());
        } finally {
            em.close();
        }
        return null;
    }
    
    public List<Usuario> findAll(){
        EntityManager em = new ConnectionDB().getConnection();
        List<Usuario> usuarios = null;
        try {
            usuarios = em.createQuery("select c from Usuario c").getResultList();
        } catch (Exception e) {
            System.err.print(e);
        }
        return usuarios;
    }
    
    public Usuario findName(String nomeUsuario){
        EntityManager em = new ConnectionDB().getConnection();
        Usuario usuario = null;
        try {
            usuario = (Usuario) em.createQuery("select c from Usuario c where c.nome = '"+nomeUsuario+"'").getSingleResult();
        } catch (Exception e) {
            System.err.print(e);
        }
        return usuario;
    }
    
    public void remove(long id) {
        EntityManager em = new ConnectionDB().getConnection();
        em.getTransaction().begin();
        try {
            Usuario u = em.find(Usuario.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
