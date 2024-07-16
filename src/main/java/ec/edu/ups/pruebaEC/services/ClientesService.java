package ec.edu.ups.pruebaEC.services;

import java.util.List;

import ec.edu.ups.pruebaEC.business.GestionClientes;
import ec.edu.ups.pruebaEC.modelo.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClientesService {
    
    @Inject
    private GestionClientes gClientes;
    
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Cliente cliente) {
        try {
            gClientes.createCliente(cliente);
            return Response.ok(cliente).build();
        } catch(Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }
    

    @GET
    @Produces("application/json")
    @Path("/{cedula}")
    public Cliente get(@PathParam("cedula") String cedula) {
        Cliente cliente;
        try {
            cliente = gClientes.getCliente(cedula);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @GET
    @Produces("application/json")
    public List<Cliente> list() {
        List<Cliente> clientes = gClientes.getClientes();
        return clientes;
    }
}


