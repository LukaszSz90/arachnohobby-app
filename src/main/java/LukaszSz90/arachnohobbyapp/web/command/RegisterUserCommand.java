package LukaszSz90.arachnohobbyapp.web.command;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class RegisterUserCommand {

    @NotNull @Email
    private String username;

    @NotBlank @Size(min = 4, max = 128)
    private String password;
}
