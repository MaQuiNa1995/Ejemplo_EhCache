package es.maquina.ehcache.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public abstract class AbstractRepositoryImplTest<K extends Number, T extends Identificable<K>> {

	@PersistenceContext
	protected EntityManager em;

	public abstract GenericRepository<K, T> getRepository();

	public abstract T getInstanceDeTParaNuevo();

	public abstract T getInstanceDeTParaLectura();

	public abstract boolean sonDatosIguales(T t1, T t2);

	public abstract K getClavePrimariaNoExistente();

	public abstract T getInstanceDeTParaModificar(K clave);

	@Test
	public void testAdd() {
		T instancia = getInstanceDeTParaNuevo();
		assertNull(instancia.getId());

		instancia = getRepository().add(instancia);

		assertNotNull(instancia.getId());
	}

	@Test
	public void testRead() {
		K clavePrimaria = generaDatoLectura();

		T resultado = getRepository().read(clavePrimaria);

		assertTrue(sonDatosIguales(getInstanceDeTParaLectura(), resultado));
	}

	@Test(expected = PersistenceException.class)
	public void testRead_NoExiste() {
		K clavePrimaria = getClavePrimariaNoExistente();

		getRepository().read(clavePrimaria);
	}

	@Test
	public void testList() {
		generaDatoLectura();
		generaDatoLectura();
		generaDatoLectura();

		List<T> resultado = getRepository().list();

		assertTrue(resultado.size() >= 3);
	}

	@Test
	public void testUpdate() {
		K clavePrimaria = generaDatoLectura();

		T sala2 = getInstanceDeTParaModificar(clavePrimaria);

		getRepository().update(sala2);

		T enBBDD = em.find(getRepository().getClassDeT(), clavePrimaria);

		assertTrue(sonDatosIguales(getInstanceDeTParaModificar(clavePrimaria), enBBDD));
	}

	@Test
	public void testDelete() {
		K clavePrimaria = generaDatoLectura();

		getRepository().delete(clavePrimaria);
		Identificable<?> c;
		try {
			c = em.find(getRepository().getClassDeT(), clavePrimaria);
		} catch (PersistenceException exception) {
			c = null;
		}
		assertNull(c);
	}

	private K generaDatoLectura() {
		T instancia = getInstanceDeTParaLectura();

		em.persist(instancia);

		return instancia.getId();
	}

}
