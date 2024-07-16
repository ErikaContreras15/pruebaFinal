package ec.edu.ups.pruebaEC.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="TBL_CLIENTE")
public class Cliente {

	@Id
	@Column(name = "cli_cedula")
	private String cedula;
	
	@Column(name = "cli_nombre")
	private String nombre;

	
	@Column(name = "cli_mes")
	private String mes;
	
	@Column(name = "cli_total_pagar")
	private double total_pagar;

	
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getTotal_pagar() {
		return total_pagar;
	}

	public void setTotal_pagar(double total_pagar) {
		this.total_pagar = total_pagar;
	}
	


}

