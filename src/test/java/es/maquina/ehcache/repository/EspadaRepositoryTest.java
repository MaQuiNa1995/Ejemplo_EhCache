package es.maquina.ehcache.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.maquina.ehcache.configuration.ConfigurationSpring;
import es.maquina.ehcache.configuration.LiquibaseConfig;
import es.maquina.ehcache.dominio.Espada;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
public class EspadaRepositoryTest extends AbstractRepositoryImplTest<Long, Espada> {

	private EspadaRepository sut;

	@Override
	public GenericRepository<Long, Espada> getRepository() {
		return sut;
	}

	@Override
	public Espada getInstanceDeTParaNuevo() {
		Espada espada = new Espada();
		espada.setNombre("Espada Celestial");
		return espada;
	}

	@Override
	public Espada getInstanceDeTParaLectura() {
		Espada espada = new Espada();
		espada.setNombre("Espada Celestial");
		return espada;
	}

	@Override
	public boolean sonDatosIguales(Espada t1, Espada t2) {
		if (t1 == null || t2 == null) {
			throw new UnsupportedOperationException("No puedo comparar nulos");
		}

		if (!t1.getNombre().equals(t2.getNombre())) {
			return false;
		}

		return true;
	}

	@Override
	public Long getClavePrimariaNoExistente() {

		return Long.MAX_VALUE;

	}

	@Override
	public Espada getInstanceDeTParaModificar(Long clave) {
		Espada espada = getInstanceDeTParaLectura();
		espada.setId(clave);
		espada.setNombre("Espada Celestial");
		return espada;
	}

	@Autowired
	public void setEspadaRepository(EspadaRepository sut) {
		this.sut = sut;
	}

}
