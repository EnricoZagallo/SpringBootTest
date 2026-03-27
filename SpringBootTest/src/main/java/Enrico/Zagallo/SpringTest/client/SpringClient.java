package Enrico.Zagallo.SpringTest.client;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Animal> entity = new RestTemplate().getForEntity("http://localhost:8080/animals/{id}", Animal.class,2);
        log.info(entity);

        Animal object = new RestTemplate().getForObject("http://localhost:8080/animals/{id}", Animal.class,2);

        log.info(object);

        Animal[] animals = new RestTemplate().getForObject("http://localhost:8080/animals/all", Animal[].class);

        log.info(Arrays.toString(animals));

        ResponseEntity<List<Animal>> exchange = new RestTemplate().exchange("http://localhost:8080/animals/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        log.info(exchange.getBody());
    }
}
