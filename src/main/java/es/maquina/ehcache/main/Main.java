package es.maquina.ehcache.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.maquina.ehcache.configuration.ConfiguracionSpring;
import es.maquina.ehcache.configuration.EhCacheConfig;
import es.maquina.ehcache.configuration.LiquibaseConfig;
import es.maquina.ehcache.dominio.Espada;
import es.maquina.ehcache.service.EspadaServiceImpl;

public class Main {

	/** Logger genérico de la clase. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		EspadaServiceImpl espadaService = null;

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfiguracionSpring.class,
				LiquibaseConfig.class, EhCacheConfig.class)) {

			espadaService = (EspadaServiceImpl) ctx.getBean("espadaService");

			Espada espada = new Espada();
			espada.setCrafteable(Boolean.TRUE);
			espada.setDanno(325);
			espada.setNombre("Espada Champiñon");
			espada.setPropiedad("+4% Crítico");
			espada.setRetroceso(50);
			espada.setVelocidad(4);

			espadaService.aniadirEspada(espada);
			LOGGER.info("Espada Añadida: " + espada.toString());

			espadaService.obtenerEspada(espada.getId());

			espadaService.obtenerEspada(espada.getId());

		}

		System.exit(0);
	}

}
