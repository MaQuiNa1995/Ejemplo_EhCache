package es.maquina.ehcache.repository;

import es.maquina.ehcache.dominio.Espada;

public interface EspadaRepository extends GenericRepository<Espada> {

	Espada find(Long id);

	void remove(Espada espadaBorrar);

}
