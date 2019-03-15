package es.maquina.ehcache.service;

import es.maquina.ehcache.dominio.Espada;

public interface EspadaService {

	public Espada actualizarEspada(Espada espada);

	public Espada aniadirEspada(Espada espada);

	public void borrarEspada(Long id);

	public Espada obtenerEspada(Long id);

}
