package es.maquina.ehcache.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import es.maquina.ehcache.repository.EspadaRepositoryImpl;

@Entity
@Table(name = EspadaRepositoryImpl.NOMBRE_TABLA)
public class Espada implements Serializable {

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

    public Long getId() {
	return this.id;
    }

    public Espada setId(Long id) {
	this.id = id;
	return this;
    }

    public String getNombre() {
	return nombre;
    }

    public Espada setNombre(String nombre) {
	this.nombre = nombre;
	return this;
    }

    public int getDanno() {
	return danno;
    }

    public Espada setDanno(int danno) {
	this.danno = danno;
	return this;
    }

    public String getPropiedad() {
	return propiedad;
    }

    public Espada setPropiedad(String propiedad) {
	this.propiedad = propiedad;
	return this;
    }

    public boolean isCrafteable() {
	return crafteable;
    }

    public Espada setCrafteable(boolean crafteable) {
	this.crafteable = crafteable;
	return this;
    }

    public int getVelocidad() {
	return velocidad;
    }

    public Espada setVelocidad(int velocidad) {
	this.velocidad = velocidad;
	return this;
    }

    public int getRetroceso() {
	return retroceso;
    }

    public Espada setRetroceso(int retroceso) {
	this.retroceso = retroceso;
	return this;
    }

    @Override
    public String toString() {
	return "Espada [id=" + id + ", nombre=" + nombre + ", danno=" + danno + ", propiedad=" + propiedad
		+ ", crafteable=" + crafteable + ", velocidad=" + velocidad + ", retroceso=" + retroceso + "]";
    }

}
