package LukaszSz90.arachnohobbyapp.web.converter;

import LukaszSz90.arachnohobbyapp.data.LifeStyleSummary;
import LukaszSz90.arachnohobbyapp.domain.model.LifeStyle;
import LukaszSz90.arachnohobbyapp.web.command.CreateLifeStyleCommand;
import org.springframework.stereotype.Component;

@Component
public class LifeStyleConverter {

    public LifeStyle from(CreateLifeStyleCommand lifeStyleCommand) {
        return LifeStyle.builder()
                .name(lifeStyleCommand.getName())
                .build();
    }

    public LifeStyleSummary toLifeStyleSummary(LifeStyle lifeStyle) {
        return LifeStyleSummary.builder()
                .id(lifeStyle.getId())
                .name(lifeStyle.getName())
                .build();
    }
}
