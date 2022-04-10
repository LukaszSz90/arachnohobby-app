package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.converter.LifeStyleConverter;
import LukaszSz90.arachnohobbyapp.data.LifeStyleSummary;
import LukaszSz90.arachnohobbyapp.domain.model.LifeStyle;
import LukaszSz90.arachnohobbyapp.domain.repository.LifeStyleRepository;
import LukaszSz90.arachnohobbyapp.exception.LifeStyleAlreadyExistException;
import LukaszSz90.arachnohobbyapp.web.command.CreateLifeStyleCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j @RequiredArgsConstructor
public class LifeStyleService {

    private final LifeStyleRepository lifeStyleRepository;
    private final LifeStyleConverter lifeStyleConverter;

    @Transactional
    public Long create(CreateLifeStyleCommand lifeStyleCommand) {
        log.debug("Data to create arachnid life style: {}", lifeStyleCommand);

        if(lifeStyleRepository.existsByName(lifeStyleCommand.getName())) {
            log.debug("Trying to add a life style with an existing name");
            throw new LifeStyleAlreadyExistException(
                    String.format("Arachnid life style at name %s is already exist",lifeStyleCommand.getName())
            );
        }

        LifeStyle lifeStyle = lifeStyleConverter.from(lifeStyleCommand);
        lifeStyleRepository.save(lifeStyle);

        log.debug("LifeStyle has been saved: {}", lifeStyle);
        return lifeStyle.getId();
    }

    @Transactional
    public List<LifeStyleSummary> getAllLifeStyle() {
        return lifeStyleRepository.findAll()
                .stream()
                .map((x) -> lifeStyleConverter.toLifeStyleSummary(x))
                .collect(Collectors.toList());
    }
}
