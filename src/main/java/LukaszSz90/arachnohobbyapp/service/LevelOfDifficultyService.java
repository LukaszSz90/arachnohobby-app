package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.converter.LevelOfDifficultyConverter;
import LukaszSz90.arachnohobbyapp.data.LevelOfDifficultySummary;
import LukaszSz90.arachnohobbyapp.domain.model.LevelOfDifficulty;
import LukaszSz90.arachnohobbyapp.domain.repository.LevelOfDifficultyRepository;
import LukaszSz90.arachnohobbyapp.exception.LevelOfDifficultyAlreadyExistException;
import LukaszSz90.arachnohobbyapp.web.command.CreateLevelOfDifficultyCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j @RequiredArgsConstructor
public class LevelOfDifficultyService {

    private final LevelOfDifficultyRepository levelOfDifficultyRepository;
    private final LevelOfDifficultyConverter levelOfDifficultyConverter;

    @Transactional
    public Long create(CreateLevelOfDifficultyCommand levelOfDifficultyCommand) {
        log.debug("Data to create arachnid level of difficulty: {}", levelOfDifficultyCommand);

        if(levelOfDifficultyRepository.existsByName(levelOfDifficultyCommand.getLevelName())){
            log.debug("Trying to add a level of difficulty with an existing name");
            throw new LevelOfDifficultyAlreadyExistException(
                    String.format("Arachnid level of difficulty at name %s is already exist", levelOfDifficultyCommand.getLevelName())
            );
        }

        LevelOfDifficulty levelOfDifficulty = levelOfDifficultyConverter.from(levelOfDifficultyCommand);
        levelOfDifficultyRepository.save(levelOfDifficulty);

        log.debug("Level of difficulty has been saved: {}", levelOfDifficulty);
        return levelOfDifficulty.getId();
    }

    @Transactional
    public List<LevelOfDifficultySummary> getAllLevelOfDifficulty() {
        return levelOfDifficultyRepository.findAll()
                .stream()
                .map((x) -> levelOfDifficultyConverter.toLevelOfDifficultySummary(x))
                .collect(Collectors.toList());
    }


}
