package es.maquina.ehcache.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
@ComponentScan(basePackages = "es.maquina.ehcache")
public class EhCacheConfig {

    @Bean
    public CacheManager cacheManager() {
	return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
	EhCacheManagerFactoryBean ehCache = new EhCacheManagerFactoryBean();
	ehCache.setConfigLocation(new ClassPathResource("EhcacheConfig.xml"));
	ehCache.setShared(Boolean.FALSE);
	return ehCache;
    }
}