package es.maquina.ehcache.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/**
 * The Class GenericDaoImpl.
 * 
 * @param <M> the generic type
 */
public abstract class GenericRepositoryImpl<M> implements GenericRepository<M> {

    /**
     * El entity manager
     */
    @PersistenceContext(name = "MaQuiNaPersistenceUnit")
    protected EntityManager entityManager;

    @Override
    @Transactional
    public M persist(M objetoPersistir) {
	entityManager.persist(objetoPersistir);
	return objetoPersistir;
    }

    @Override
    @Transactional
    public M findById(Long id) {
	return entityManager.find(getClassDeM(), id);
    }

    @Override
    @Transactional
    public M merge(M objetoUpdatear) {
	entityManager.merge(objetoUpdatear);
	return objetoUpdatear;
    }

    @Override
    @Transactional
    public void remove(Long id) {
	M objetoEliminar = entityManager.find(getClassDeM(), id);
	entityManager.remove(objetoEliminar);

    }

}
