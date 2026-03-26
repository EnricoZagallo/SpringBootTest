package Enrico.Zagallo.SpringTest.Controller;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import Enrico.Zagallo.SpringTest.Service.AnimalService;
import Enrico.Zagallo.SpringTest.Util.DateUtil;
import Enrico.Zagallo.SpringTest.requests.AnimalPostRequestBody;
import Enrico.Zagallo.SpringTest.requests.AnimalPutRequestBody;
//import jakarta.validation.Valid;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animals")
@Log4j2
@AllArgsConstructor
public class AnimalsController {

    private DateUtil dateUtil;
    private final AnimalService animeService;


    //http://localhost:8080/animals/list
    @GetMapping
    public ResponseEntity<List<Animal>> list() {
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listall());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
    }
    @GetMapping(path = "/{name}")
    public ResponseEntity<List<Animal>> findByName(@RequestParam String  name) {

        return ResponseEntity.ok(animeService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Animal> save(@RequestBody @Valid AnimalPostRequestBody animalPostRequestBody) {
        return new ResponseEntity<>(animeService.save(animalPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
 animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimalPutRequestBody animalPutRequestBody) {
        animeService.replace(animalPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
