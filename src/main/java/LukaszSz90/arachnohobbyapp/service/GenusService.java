package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.web.converter.GenusConverter;
import LukaszSz90.arachnohobbyapp.data.GenusSummary;
import LukaszSz90.arachnohobbyapp.domain.model.Genus;
import LukaszSz90.arachnohobbyapp.domain.repository.GenusRepository;
import LukaszSz90.arachnohobbyapp.exception.GenusAlreadyExistException;
import LukaszSz90.arachnohobbyapp.web.command.CreateGenusCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j @RequiredArgsConstructor
public class GenusService {

    private final GenusRepository genusRepository;
    private final GenusConverter genusConverter;

    @Transactional
    public Long create(CreateGenusCommand genuscommand) {
        log.debug("Data to create arachnid genus: {}", genuscommand);

        if(genusRepository.existsByName(genuscommand.getName())) {
            log.debug("Trying to add a genus with an existing name");
            throw new GenusAlreadyExistException(
                    String.format("Arachnid genus at name %s is already exist", genuscommand.getName())
            );
        }

        Genus genus = genusConverter.from(genuscommand);
        genusRepository.save(genus);

        log.debug("Genus has been saved: {}", genus);
        return genus.getId();
    }

    @Transactional
    public List<GenusSummary> getAllGenus() {
        return genusRepository.findAll()
                .stream()
                .map((x) -> genusConverter.toGenusSummary(x))
                .collect(Collectors.toList());
    }


}
