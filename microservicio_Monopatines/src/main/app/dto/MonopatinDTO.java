package main.app.dto;

import java.util.Objects;

import main.app.model.Monopatin;

public class MonopatinDTO {
	
	private Integer id;

	private boolean isDisponible;

	private boolean isEncendido;

	private double longitud;
	
	private double latitud;

	private boolean mantenimiento;
	
	private Integer parada;

	public MonopatinDTO() {
	}
	
	

	public MonopatinDTO(Integer id, boolean isDisponible, boolean isEncendido, double longitud, double latitud,
			boolean mantenimiento, Integer parada) {
		super();
		this.id = id;
		this.isDisponible = isDisponible;
		this.isEncendido = isEncendido;
		this.longitud = longitud;
		this.latitud = latitud;
		this.mantenimiento = mantenimiento;
		this.parada = parada;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public boolean isEncendido() {
		return isEncendido;
	}

	public void setEncendido(boolean isEncendido) {
		this.isEncendido = isEncendido;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isDisponible, isEncendido, latitud, longitud);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonopatinDTO other = (MonopatinDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	public boolean isMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(boolean mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	public void completarInfo(Monopatin monopatin) {
		this.setDisponible(monopatin.isDisponible());
		this.setEncendido(monopatin.isEncendido());
		this.setLatitud(monopatin.getLatitud());
		this.setLongitud(monopatin.getLongitud());
	}

	public Integer getParada() {
		return parada;
	}

	public void setParada(Integer parada) {
		this.parada = parada;
	}
	
	
}
