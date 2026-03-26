package Enrico.Zagallo.SpringTest.requests;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class AnimalPostRequestBody {
    @NotEmpty(message = "The animal cannot be empty")
    @NotNull(message = "The animal cannot be null")
    private String name;

}
