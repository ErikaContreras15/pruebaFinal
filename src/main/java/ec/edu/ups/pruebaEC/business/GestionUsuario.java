package ec.edu.ups.pruebaEC.business;

import java.util.List;
import ec.edu.ups.pruebaEC.modelo.Cliente;
import ec.edu.ups.pruebaEC.modelo.Consumo;
import ec.edu.ups.pruebaEC.dao.ClienteDAO;
import ec.edu.ups.pruebaEC.dao.ConsumoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionUsuario {
	@Inject
	private ClienteDAO daoCliente;   
	
	@Inject
	private ConsumoDAO daoConsumo;  
	
	@PostConstruct
	public void init() {
		
		System.out.println("PRUEBA UNIDAD 4");
		
		
		Cliente cliente  = new Cliente();
		cliente.setCedula("0106786633");
		cliente.setNombre("Anabel");
		cliente.setMes("Mayo");
	      cliente.setTotal_pagar(60);
		daoCliente.insert(cliente);
		
		
		List<Cliente> listado = daoCliente.getAll();
		for(Cliente cli: listado) {
			System.err.println(cli.getCedula() + " " + cli.getNombre()+ " "+cli.getMes() + " "+ cli.getTotal_pagar());
		}    
	
	/*
	Consumo consumo= new Consumo();
	consumo.getDeuda();

	*/
	}	

}
