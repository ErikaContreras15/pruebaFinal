package ec.edu.ups.pruebaEC.dao;


import java.io.Serializable;
import java.util.List;

import ec.edu.ups.pruebaEC.modelo.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO implements Serializable{
    @PersistenceContext
    private EntityManager em;
    
    public void insert(Cliente cliente) {
        em.persist(cliente);
    }

    public void update(Cliente cliente) {
        em.merge(cliente);
    }
    
    public Cliente read(String cedula) {
        return em.find(Cliente.class, cedula);
    }
    
    public void delete(String cedula) {
        Cliente cliente = em.find(Cliente.class, cedula);
        if (cliente != null) {
            em.remove(cliente);
        }
    }
    
    public List<Cliente> getAll(){
        String jpql = "SELECT c FROM Cliente c";
        Query query = em.createQuery(jpql, Cliente.class);
        return query.getResultList();
    }
}
