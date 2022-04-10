package LukaszSz90.arachnohobbyapp.converter;

import LukaszSz90.arachnohobbyapp.data.LevelOfDifficultySummary;
import LukaszSz90.arachnohobbyapp.domain.model.LevelOfDifficulty;
import LukaszSz90.arachnohobbyapp.web.command.CreateLevelOfDifficultyCommand;
import org.springframework.stereotype.Component;


@Component
public class LevelOfDifficultyConverter {

    public LevelOfDifficulty from(CreateLevelOfDifficultyCommand levelOfDifficultyCommand) {
        return LevelOfDifficulty.builder()
                .levelName(levelOfDifficultyCommand.getLevelName())
                .build();
    }

    public LevelOfDifficultySummary toLevelOfDifficultySummary(LevelOfDifficulty levelOfDifficulty) {
        return LevelOfDifficultySummary.builder()
                .id(levelOfDifficulty.getId())
                .levelName(levelOfDifficulty.getLevelName())
                .build();

    }

}
