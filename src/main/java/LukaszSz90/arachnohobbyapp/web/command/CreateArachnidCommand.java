package LukaszSz90.arachnohobbyapp.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateArachnidCommand {

    @NotNull
    private String species;

    @NotNull
    private String temperament;

    @NotNull
    private String temperatureMin;

    @NotNull
    private String temperatureMax;

    @NotNull
    private String humidityMin;

    @NotNull
    private String humidityMax;

    @NotNull
    private String venomForce;

    private String description;

    private String areaOfOccurrence;

    @NotNull
    private String maxSize;

    @NotNull
    private Long levelOdDifficultyId;

    @NotNull
    private Long genusId;

    @NotNull
    private Long lifeStyleId;

}
