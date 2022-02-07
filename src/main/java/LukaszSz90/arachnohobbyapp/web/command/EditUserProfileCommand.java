package LukaszSz90.arachnohobbyapp.web.command;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EditUserProfileCommand {

    @NotBlank
    @Size(min = 2, max = 20)
    private String nickName;
    @NotBlank
    private LocalDate breedingPeriod;
    @NotBlank
    private String livingLocalisation;
}
