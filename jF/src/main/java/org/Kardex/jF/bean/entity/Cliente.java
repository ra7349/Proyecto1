package org.Kardex.jF.bean.entity;

public class Cliente extends Persona {

	private String direccion;
	private String tipoCliente;
	private Integer RUC;
	private String codigo;
	
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	public Integer getRUC() {
		return RUC;
	}
	public void setRUC(Integer rUC) {
		RUC = rUC;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
