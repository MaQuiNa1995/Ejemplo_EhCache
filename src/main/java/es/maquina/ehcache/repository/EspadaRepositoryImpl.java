package es.maquina.ehcache.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina.ehcache.dominio.Espada;

@Repository
@Transactional
public class EspadaRepositoryImpl extends GenericRepositoryImpl<Long, Espada> implements EspadaRepository {

	public static final String NOMBRE_TABLA = "ESPADA";

	@Override
	public Class<Espada> getClassDeT() {
		return Espada.class;
	}

	@Override
	public String getNombreTabla() {
		return NOMBRE_TABLA;
	}
}
