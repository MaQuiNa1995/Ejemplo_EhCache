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

	    EspadaService espadaService =  ctx.getBean("espadaService", EspadaService.class);

	    Espada espada = new Espada()
		    .setCrafteable(Boolean.TRUE)
		    .setDanno(325)
		    .setNombre("Espada Champiñón")
		    .setPropiedad("+4% Crítico")
		    .setRetroceso(50)
		    .setVelocidad(4);

	    
	    LOGGER.info("-------------------------------------------------------");
	    espadaService.aniadirEspada(espada);
	    LOGGER.info("Espada Añadida: " + espada.toString());
	   
	    espadaService.obtenerEspada(espada.getId());
	    LOGGER.info("No tarda casi nada porque está cacheado en memoria");
	    espadaService.borrarEspada(0L);

	    espada.setId(null);
	    
	    LOGGER.info("Se llama de nuevo a la base de datos ya que se ha eliminado de la cache y de la base de datos el objeto");
	    espadaService.aniadirEspada(espada);
	    espadaService.obtenerEspada(espada.getId());
	    LOGGER.info("-------------------------------------------------------");

	}

	System.exit(0);
    }

}
