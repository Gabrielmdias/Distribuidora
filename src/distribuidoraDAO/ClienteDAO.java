/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidoraDAO;

import connectionDB.ConnectionDB;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author Gabriel
 */
public class ClienteDAO extends GenericDAO<Cliente>{
    
    public List<Cliente> findAll(){
        EntityManager em = new ConnectionDB().getConnection();
        List<Cliente> clientes = null;
        try {
            clientes = em.createQuery("select c from Cliente c").getResultList();
        } catch (Exception e) {
            System.err.print(e);
        }
        return clientes;
    }
}
