package com.carBackEndApps;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.carBackEndApps.model.Car;
import com.carBackEndApps.repository.CarRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//@EnableResourceServer
@SpringBootApplication
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository repository) {
        Car[] car = {new Car("Range Rover", "Best Rider"), new Car("Chevrolet", "This is an American rover"),
        		new Car("Ford", "The perspective of future"), new Car("Peugeot", "Tout pour l'aventure"), new Car("Huiyndai", "The new millenium dusk"), new Car("Toyota", "Ready for new adventure"), new Car("Mercedes", "Mercedes the best car ever"), new Car("Volkswagen", "Volkswagen will not age"),
        		new Car("Toyota Starex", "Toyota Starex your friend everywhere")};
       return args ->{ Stream.of(car).forEach(x->{
        	Car  saveCar = new Car("", "");
        	saveCar = x;
        	repository.save(saveCar);
        });
        	//fin
           repository.findAll().forEach(System.out::println);
    };
}

    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
