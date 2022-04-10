package LukaszSz90.arachnohobbyapp.data;

import LukaszSz90.arachnohobbyapp.domain.model.Genus;
import LukaszSz90.arachnohobbyapp.domain.model.LevelOfDifficulty;
import LukaszSz90.arachnohobbyapp.domain.model.LifeStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArachnidSummary {

    private Long id;
    private String species;
    private String temperatureMin;
    private String temperatureMax;
    private String humidityMin;
    private String humidityMax;
    private String venomForce;
    private String description;
    private String maxSize;
    private String areaOfOccurrence;
    private String photoUrl;
    private LevelOfDifficulty levelOfDifficulty;
    private Genus genus;
    private LifeStyle lifeStyle;

}
