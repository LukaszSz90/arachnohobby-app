package LukaszSz90.arachnohobbyapp.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserSummary {

    private String nickName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate breedingPeriod;

    private String livingLocalisation;
    private String pictureNameUrl;
}
