package es.maquina.ehcache.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina.ehcache.dominio.Espada;

@Repository("EspadaRepository")
public class EspadaRepositoryImpl extends GenericRepositoryImpl<Espada> implements EspadaRepository {

	public static final String NOMBRE_TABLA = "ESPADA";

	@Cacheable("customCache")
	@Override
	public Espada find(Long id) {
		return entityManager.find(getClassDeM(), id);
	}

	@Override
	public Class<Espada> getClassDeM() {
		return Espada.class;
	}

	@Transactional
	@Override
	public void remove(Espada espadaBorrar) {
		entityManager.remove(espadaBorrar);

	}

}
