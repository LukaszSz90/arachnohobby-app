package LukaszSz90.arachnohobbyapp.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateLifeStyleCommand {

    @NotNull
    private String name;
}
