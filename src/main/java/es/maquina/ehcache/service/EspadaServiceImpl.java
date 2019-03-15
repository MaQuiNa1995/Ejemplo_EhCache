package es.maquina.ehcache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.maquina.ehcache.dominio.Espada;
import es.maquina.ehcache.repository.EspadaRepository;

@Service
public class EspadaServiceImpl implements EspadaService {

	private EspadaRepository espadaRepository;

	@Override
	public Espada actualizarEspada(Espada modificada) {
		return espadaRepository.update(modificada);
	}

	@Override
	public Long aniadirEspada(String nombre) {
		Espada espada = new Espada();
		espada.setNombre(nombre);

		return aniadirEspada(espada).getId();
	}

	private Espada aniadirEspada(Espada nueva) {
		return espadaRepository.add(nueva);
	}

	@Override
	public void borrarEspada(Long id) {
		Espada aBorrar = obtenerEspada(id);
		espadaRepository.delete(aBorrar);
	}

	@Override
	public Espada obtenerEspada(Long id) {
		return espadaRepository.read(id);
	}

	@Override
	public List<Espada> obtenerEspadas() {
		return espadaRepository.list();
	}

	@Autowired
	public void setTrabajadorRepository(EspadaRepository trabajadorRepository) {
		this.espadaRepository = trabajadorRepository;
	}
}
