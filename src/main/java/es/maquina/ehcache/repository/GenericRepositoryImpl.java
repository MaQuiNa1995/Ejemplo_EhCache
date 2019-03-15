package es.maquina.ehcache.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class GenericRepositoryImpl<K extends Number, T extends Identificable<K>>
		implements GenericRepository<K, T> {

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	@Override
	public T add(T nuevo) {
		entityManager.persist(nuevo);
		return nuevo;
	}

	@Override
	public T read(K id) {
		return entityManager.find(getClassDeT(), id);
	}

	@Override
	public List<T> list() {
		return entityManager.createQuery("select * from " + getNombreTabla(), getClassDeT()).getResultList();
	}

	@Transactional
	@Override
	public void delete(K id) {
		T aBorrar = entityManager.find(getClassDeT(), id);
		delete(aBorrar);
	}

	@Transactional
	@Override
	public void delete(T aBorrar) {
		entityManager.remove(aBorrar);
	}

	@Transactional
	@Override
	public T update(T modificado) {
		return entityManager.merge(modificado);
	}
}
