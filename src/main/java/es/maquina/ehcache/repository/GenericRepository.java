package es.maquina.ehcache.repository;

import java.util.List;

public interface GenericRepository<K extends Number, T extends Identificable<K>> {

	T add(T nuevo);

	T read(K id);

	List<T> list();

	T update(T modificado);

	void delete(K id);

	void delete(T aBorrar);

	public abstract Class<T> getClassDeT();

	public abstract String getNombreTabla();
}