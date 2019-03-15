/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.maquina.ehcache.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.maquina.ehcache.configuration.ConfigurationSpring;
import es.maquina.ehcache.configuration.LiquibaseConfig;
import es.maquina.ehcache.dominio.Espada;
import es.maquina.ehcache.repository.EspadaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigurationSpring.class, LiquibaseConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public class EspadaServiceImplTest {

	private EspadaService cut;
	private EspadaRepository espadaRepository;

	@Before
	public void setUp() throws Exception {
		limpiarEspadas();
	}

	@Test
	public void testAniadirBase() {
		Long idEspada = cut.aniadirEspada("Espada De La Jungla");

		assertNotNull(idEspada);
	}

	@Test
	public void testObtenerBase() {
		Long idTrabajador = cut.aniadirEspada("Espada De La Jungla");

		Espada espada = cut.obtenerEspada(idTrabajador);

		assertNotNull(espada.getId());
		assertTrue(espada.getNombre().equalsIgnoreCase("Espada De La Jungla"));
	}

	@Test
	public void testObtenerBases() {
		List<Espada> espadas = cut.obtenerEspadas();
		espadas.forEach((espada) -> {
			assertNotNull(espada.getId());
		});
	}

	@Test
	public void testActualizarBase() {
		Long idEspada = cut.aniadirEspada("Espada De La Jungla");

		Espada trabajador = cut.obtenerEspada(idEspada);
		trabajador.setNombre("Espada De La Jungla");

		Espada espadaMod = cut.obtenerEspada(idEspada);

		assertTrue(espadaMod.getNombre().equalsIgnoreCase("Espada De La Jungla"));
	}

	@Test
	public void testBorrarBase() {
		Long idTrabajador = cut.aniadirEspada("Sonda");

		cut.borrarEspada(idTrabajador);

		List<Espada> trabajadors = cut.obtenerEspadas();

		assertTrue(trabajadors.isEmpty());
	}

	private void limpiarEspadas() {
		List<Espada> espadas = cut.obtenerEspadas();
		espadas.forEach((espada) -> {
			espadaRepository.delete(espada);
		});
	}

	@Autowired
	public void setEspadaService(EspadaService sut) {
		this.cut = sut;
	}

	@Autowired
	public void setEspadaRepository(EspadaRepository espadaRepository) {
		this.espadaRepository = espadaRepository;
	}
}
