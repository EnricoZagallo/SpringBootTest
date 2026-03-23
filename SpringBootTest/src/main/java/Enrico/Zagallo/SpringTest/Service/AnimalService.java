package Enrico.Zagallo.SpringTest.Service;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimalService {
    private static List<Animal> animals;

    static {
        animals = new ArrayList<>(List.of(new Animal(1L, "Cachorro"), new Animal(2L, "Gato")));
    }

    public List<Animal> listall() {
        return animals;
    }

    public Animal findById(Long id) {
        return animals.stream()
                .filter(animal -> animal.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Animal save(Animal animal) {
        animal.setId(ThreadLocalRandom.current().nextLong(3, 1_000_000));
        animals.add(animal);
        return animal;
    }

    public void delete(long id) {
        animals.remove(findById(id));
    }

    public void replace(Animal animal) {
        delete(animal.getId());
        animals.add(animal);
    }
}
