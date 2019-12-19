package ge.gngapps.playground.context.bean;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;

@Configuration
public class Beans {

    @Bean
    public Traverson getTraverson() {
        return new Traverson(URI.create("http://localhost:8080/"), MediaTypes.HAL_JSON);
    }
}
