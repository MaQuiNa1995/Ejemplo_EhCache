package es.maquina.ehcache.repository;

import org.springframework.stereotype.Repository;

import es.maquina.ehcache.dominio.Espada;

@Repository("EspadaRepository")
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
