package org.Kardex.jF.bean.entity;

import java.time.LocalDate;

public class Equipo {
private String codigo;
private String marca;
private String modelo;
private Integer numeroSerie;
private String TipoEquipo;
private Boolean estado;
private LocalDate fecha;


public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public Integer getNumeroSerie() {
	return numeroSerie;
}
public void setNumeroSerie(Integer numeroSerie) {
	this.numeroSerie = numeroSerie;
}
public String getTipoEquipo() {
	return TipoEquipo;
}
public void setTipoEquipo(String tipoEquipo) {
	TipoEquipo = tipoEquipo;
}
public Boolean getEstado() {
	return estado;
}
public void setEstado(Boolean estado) {
	this.estado = estado;
}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}

}
