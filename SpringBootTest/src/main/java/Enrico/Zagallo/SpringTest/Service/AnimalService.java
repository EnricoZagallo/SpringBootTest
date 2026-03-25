package Enrico.Zagallo.SpringTest.Service;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import Enrico.Zagallo.SpringTest.Repository.AnimalRepository;
import Enrico.Zagallo.SpringTest.requests.AnimalPostRequestBody;
import Enrico.Zagallo.SpringTest.requests.AnimalPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public List<Animal> listall() {
        return animalRepository.findAll();
    }

    public Animal findByIdOrThrowBadRequestException(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Animal save(AnimalPostRequestBody animalPostRequestBody) {
        return animalRepository.save(Animal.builder().name(animalPostRequestBody.getName()).build() );
    }

    public void delete(long id) {
        animalRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimalPutRequestBody animalPutRequestBody) {
       Animal savedAnimal = findByIdOrThrowBadRequestException(animalPutRequestBody.getId());
       Animal animal = Animal.builder()
                .id(savedAnimal.getId())
                .name(animalPutRequestBody.getName())
                .build();
        animalRepository.save(animal);
    }
}
