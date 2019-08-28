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
import modelo.EntidadeBase;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO extends GenericDAO<Usuario>{
    
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
            usuario = (Usuario) em.createQuery("select c from Usuario c where c.usuario = '"+nomeUsuario+"'").getSingleResult();
        } catch (Exception e) {
            System.err.print(e);
        }
        return usuario;
    }
    
}
