package es.maquina.ehcache.anotaciones;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TiempoEjecucionAspecto {

    /** Logger genérico de la clase. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TiempoEjecucionAspecto.class);

    private long inicioEjecucion;

    @Before("execution(* es.maquina.ehcache.service.EspadaServiceImpl.obtenerEspada(..))")
    public void logBefore(JoinPoint joinPoint) {

	inicioEjecucion = getHoraActual();
    }

    @After("execution(* es.maquina.ehcache.service.EspadaServiceImpl.obtenerEspada(..))")
    public void logAfter(JoinPoint joinPoint) {

	double tiempoEjecucion = (getHoraActual() - inicioEjecucion) / 1000D;
	LOGGER.info("Metodo Ejecutado en: " + tiempoEjecucion + " segundos !!");
    }

    private long getHoraActual() {
	return System.currentTimeMillis() % 1000;
    }

}
