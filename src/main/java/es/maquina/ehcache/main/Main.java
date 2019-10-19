package es.maquina.ehcache.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.maquina.ehcache.configuration.ConfiguracionSpring;
import es.maquina.ehcache.configuration.EhCacheConfig;
import es.maquina.ehcache.configuration.LiquibaseConfig;
import es.maquina.ehcache.dominio.Espada;
import es.maquina.ehcache.service.EspadaService;

public class Main {

    /** Logger genérico de la clase. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
	
	try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfiguracionSpring.class,
		LiquibaseConfig.class, EhCacheConfig.class)) {

	    EspadaService espadaService = (EspadaService) ctx.getBean("espadaService");

	    Espada espada = new Espada()
		    .setCrafteable(Boolean.TRUE)
		    .setDanno(325)
		    .setNombre("Espada Champiñón")
		    .setPropiedad("+4% Crítico")
		    .setRetroceso(50)
		    .setVelocidad(4);

	    espadaService.aniadirEspada(espada);
	    LOGGER.info("Espada Añadida: " + espada.toString());

	    LOGGER.info("Se trazan líneas para identificar mas rápidamente la traza de log que queremos verificar");
	    LOGGER.info("-------------------------------------------------------");
	    espadaService.obtenerEspada(espada.getId());
	    LOGGER.info("-------------------------------------------------------");
	    espadaService.obtenerEspada(espada.getId());
	    LOGGER.info("-------------------------------------------------------");

	}

	System.exit(0);
    }

}
