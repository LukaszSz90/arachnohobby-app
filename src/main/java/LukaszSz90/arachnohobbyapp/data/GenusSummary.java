package LukaszSz90.arachnohobbyapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenusSummary {

    private Long id;
    private String genusName;
}
