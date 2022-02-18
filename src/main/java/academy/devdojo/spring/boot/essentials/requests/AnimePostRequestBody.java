package academy.devdojo.spring.boot.essentials.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "The anime name canoot be empty")
    @NotNull(message = "The anime name canoot be null")
    private String name;
}
