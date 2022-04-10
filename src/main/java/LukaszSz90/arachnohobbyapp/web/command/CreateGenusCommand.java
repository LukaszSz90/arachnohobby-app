package LukaszSz90.arachnohobbyapp.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateGenusCommand {

    @NotNull @Size(min = 3, max = 50)
    private String genusName;
}
