package es.maquina.ehcache.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.maquina.ehcache.dominio.Espada;

@Repository("EspadaRepository")
public class EspadaRepositoryImpl extends GenericRepositoryImpl<Espada> implements EspadaRepository {

    public static final String NOMBRE_TABLA = "ESPADA";

    /**
     * Llamada al
     * {@link es.maquina.ehcache.repository.GenericRepository#findById(Long id)}e
     * overridea para añadir el
     * {@link org.springframework.cache.annotation.Cacheable}
     * <p>
     * Como punto adicional si el método es cacheado y se detecta que va a devolver
     * el mismo objeto que devolvió una ejecución anterior el método no se ejecuta
     * hace una especie de mockeo como el framework Mockito y el método no se
     * ejecuta
     * <p>
     * por lo que los posibles aspectos que hayan sido hookeados a este no se
     * ejecutarán
     * 
     */
    @Override
    @Cacheable(value = "espadaCache", key = "#id")
    public Espada findById(Long id) {
	return super.findById(id);
    }

    /**
     * Llamada al
     * {@link es.maquina.ehcache.repository.GenericRepository#persist(Espada espada)}
     * que overridea para añadir el
     * {@link org.springframework.cache.annotation.Cacheable}
     * <p>
     * 
     * @param espada {@link Espada} objeto a ser persistido
     * 
     * @return espada {@link Espada} objeto persistido
     */
    @Override
    @CachePut(value = "espadaCache", key = "#espada.id")
    public Espada persist(Espada espada) {
	return super.persist(espada);
    }

    /**
     * Llamada al
     * {@link es.maquina.ehcache.repository.GenericRepository#remove(Espada espada)}
     * que overridea para añadir el
     * {@link org.springframework.cache.annotation.CacheEvict}
     * 
     * @param espada {@link Espada} objeto a ser eliminado
     */
    @Override
    @Transactional
    @CacheEvict(value = "espadaCache", key = "#idEspada")
    public void remove(Long idEspada) {
	super.remove(idEspada);
    }

    @Override
    public Class<Espada> getClassDeM() {
	return Espada.class;
    }

}
