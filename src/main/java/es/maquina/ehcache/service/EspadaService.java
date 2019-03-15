package es.maquina.ehcache.service;

import java.util.List;

import es.maquina.ehcache.dominio.Espada;

public interface EspadaService {

	public Espada actualizarEspada(Espada espada);

	public Espada aniadirEspada(Espada espada);

	public void borrarEspada(Long id);

	public Espada obtenerEspada(Long id);

	public List<Espada> obtenerEspadas();

}
