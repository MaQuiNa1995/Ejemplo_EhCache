package es.maquina.ehcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.maquina.ehcache.dominio.Espada;
import es.maquina.ehcache.repository.EspadaRepository;

@Service("espadaService")
public class EspadaServiceImpl implements EspadaService {

    private EspadaRepository espadaRepository;

    @Override
    public Espada actualizarEspada(Espada modificada) {
	return espadaRepository.merge(modificada);
    }

    @Override
    public Espada aniadirEspada(Espada nueva) {
	return espadaRepository.persist(nueva);
    }

    @Override
    public void borrarEspada(Long id) {
	Espada aBorrar = obtenerEspada(id);
	espadaRepository.remove(aBorrar);
    }

    @Override
    public Espada obtenerEspada(Long id) {
	return espadaRepository.findById(id);
    }

    @Autowired
    public void setEspadaRepository(EspadaRepository espadaRepository) {
	this.espadaRepository = espadaRepository;
    }
}
