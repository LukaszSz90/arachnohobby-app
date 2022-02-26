package LukaszSz90.arachnohobbyapp.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditUserCommand {

    private String nickName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate breedingPeriod;

    private String livingLocalisation;
    private String pictureNameUrl;
}
