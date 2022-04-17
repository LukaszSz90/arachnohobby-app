package LukaszSz90.arachnohobbyapp.web.converter;

import LukaszSz90.arachnohobbyapp.data.GenusSummary;
import LukaszSz90.arachnohobbyapp.domain.model.Genus;
import LukaszSz90.arachnohobbyapp.web.command.CreateGenusCommand;
import org.springframework.stereotype.Component;

@Component
public class GenusConverter {

    public Genus from(CreateGenusCommand genusCommand) {
        return Genus.builder()
                .name(genusCommand.getName())
                .build();
    }

    public GenusSummary toGenusSummary(Genus genus) {
        return GenusSummary.builder()
                .id(genus.getId())
                .name(genus.getName())
                .build();
    }
}
