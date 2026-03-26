package mapper;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import Enrico.Zagallo.SpringTest.requests.AnimalPostRequestBody;
import Enrico.Zagallo.SpringTest.requests.AnimalPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-25T21:21:38-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AnimalMapperImpl extends AnimalMapper {

    @Override
    public Animal toanimal(AnimalPostRequestBody animalPostRequestBody) {
        if ( animalPostRequestBody == null ) {
            return null;
        }

        Animal.AnimalBuilder animal = Animal.builder();

        animal.name( animalPostRequestBody.getName() );

        return animal.build();
    }

    @Override
    public Animal toanimal(AnimalPutRequestBody animalPutRequestBody) {
        if ( animalPutRequestBody == null ) {
            return null;
        }

        Animal.AnimalBuilder animal = Animal.builder();

        animal.id( animalPutRequestBody.getId() );
        animal.name( animalPutRequestBody.getName() );

        return animal.build();
    }
}
