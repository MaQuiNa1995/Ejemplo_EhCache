package es.maquina.ehcache.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import es.maquina.ehcache.repository.EspadaRepositoryImpl;
import es.maquina.ehcache.repository.Identificable;

@Entity
@Table(name = EspadaRepositoryImpl.NOMBRE_TABLA)
public class Espada implements Identificable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8816076296136522299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DANNO")
	private int danno;

	@Column(name = "PROPIEDAD")
	private String propiedad;

	@Column(name = "CRAFTEABLE")
	private boolean crafteable;

	@Column(name = "VELOCIDAD")
	private int velocidad;

	@Column(name = "RETROCESO")
	private int retroceso;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDanno() {
		return danno;
	}

	public void setDanno(int danno) {
		this.danno = danno;
	}

	public String getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	public boolean isCrafteable() {
		return crafteable;
	}

	public void setCrafteable(boolean crafteable) {
		this.crafteable = crafteable;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getRetroceso() {
		return retroceso;
	}

	public void setRetroceso(int retroceso) {
		this.retroceso = retroceso;
	}

	@Override
	public String toString() {
		return "Espada [id=" + id + ", nombre=" + nombre + ", danno=" + danno + ", propiedad=" + propiedad
				+ ", crafteable=" + crafteable + ", velocidad=" + velocidad + ", retroceso=" + retroceso + "]";
	}

}
