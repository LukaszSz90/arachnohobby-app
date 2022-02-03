package LukaszSz90.arachnohobbyapp.web.command;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class RegisterUserCommand {

    @NotNull
    private String username;

    @NotBlank @NotNull @Email
    private String email;

    @NotBlank @Size(min = 8, max = 128)
    private String password;
}
