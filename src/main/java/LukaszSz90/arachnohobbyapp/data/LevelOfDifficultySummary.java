package LukaszSz90.arachnohobbyapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelOfDifficultySummary {

    private Long id;
    private String name;
}
