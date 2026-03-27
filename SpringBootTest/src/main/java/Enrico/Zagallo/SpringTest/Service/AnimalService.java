package Enrico.Zagallo.SpringTest.Service;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import Enrico.Zagallo.SpringTest.Repository.AnimalRepository;
import Enrico.Zagallo.SpringTest.exception.BadRequestException;
import Enrico.Zagallo.SpringTest.requests.AnimalPostRequestBody;
import Enrico.Zagallo.SpringTest.requests.AnimalPutRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mapper.AnimalMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public Page<Animal> listall(Pageable pageable) {
        return animalRepository.findAll(pageable);
    }

    public List<Animal> findByName(String name) {
        return animalRepository.findByName(name);
    }

    public Animal findByIdOrThrowBadRequestException(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    @Transactional
    public Animal save(AnimalPostRequestBody animalPostRequestBody) {
        return animalRepository.save(AnimalMapper.INSTANCE.toanimal(animalPostRequestBody));
    }

    public void delete(long id) {
        animalRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimalPutRequestBody animalPutRequestBody) {
       Animal savedAnimal = findByIdOrThrowBadRequestException(animalPutRequestBody.getId());
        Animal animal = AnimalMapper.INSTANCE.toanimal(animalPutRequestBody);
        animal.setId(savedAnimal.getId());
        animalRepository.save(animal);
    }
}
