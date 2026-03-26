package mapper;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import Enrico.Zagallo.SpringTest.requests.AnimalPostRequestBody;
import Enrico.Zagallo.SpringTest.requests.AnimalPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimalMapper {
    public static final AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);
    public abstract Animal toanimal(AnimalPostRequestBody animalPostRequestBody);

    public abstract Animal toanimal(AnimalPutRequestBody animalPutRequestBody);
}
