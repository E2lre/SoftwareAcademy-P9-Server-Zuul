package com.mediscreen.zuulserver;

import com.mediscreen.zuulserver.filter.LogFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {
    private static final Logger logger = LogManager.getLogger(ZuulServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
        logger.info("*-- FilterRegistrationBean : Start");
		UrlBasedCorsConfigurationSource source =
				new UrlBasedCorsConfigurationSource();

		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);

		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean<CorsFilter> bean =
				new FilterRegistrationBean<>(new CorsFilter(source));

		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return bean;
	}

}
