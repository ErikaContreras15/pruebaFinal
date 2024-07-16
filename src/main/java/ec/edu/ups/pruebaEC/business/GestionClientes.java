package ec.edu.ups.pruebaEC.business;


import java.util.List;

import ec.edu.ups.pruebaEC.modelo.Cliente;
import ec.edu.ups.pruebaEC.dao.ClienteDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


@Stateless
public class GestionClientes {
    

    @Inject
    private ClienteDAO daoCliente;
    
    public Cliente getCliente(String cedula) throws Exception {
        if (cedula.length() != 10) {
            throw new Exception("Cedula incorrecta");
        }
        Cliente cliente = daoCliente.read(cedula);
        if (cliente == null) {
            throw new Exception("Cedula no existe");
        }
        return cliente;
    }
    
    public List<Cliente> getClientes() {
        return daoCliente.getAll();
    }
    
    public void createCliente(Cliente cliente) throws Exception {
        if (cliente.getCedula().length() != 10) {
            throw new Exception("Cedula incorrecta");
        }
        daoCliente.insert(cliente);
    }
  
}

