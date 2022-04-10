package LukaszSz90.arachnohobbyapp.service;

import LukaszSz90.arachnohobbyapp.converter.ArachnidConverter;
import LukaszSz90.arachnohobbyapp.domain.model.Arachnid;
import LukaszSz90.arachnohobbyapp.domain.repository.ArachnidRepository;
import LukaszSz90.arachnohobbyapp.domain.repository.GenusRepository;
import LukaszSz90.arachnohobbyapp.exception.ArachnidAlreadyExistException;
import LukaszSz90.arachnohobbyapp.web.command.CreateArachnidCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArachnidService {

    private final GenusRepository genusRepository;
    private final ArachnidRepository arachnidRepository;
    private final ArachnidConverter arachnidConverter;

    @Transactional
    public Long create(CreateArachnidCommand arachnid) {
        log.debug("Data to create arachnid: {}", arachnid);

        if (arachnidRepository.existBySpecies(arachnid.getSpecies())) {
            log.debug("Arachnid is already exist");
            throw new ArachnidAlreadyExistException(
                    String.format("An arachnid named %s %s already exists.", genusRepository.getNameById(arachnid.getGenusId()))
            );
        }

        Arachnid arachnidToSave = arachnidConverter.from(arachnid);

        if(arachnidToSave.getPhotoUrl().isBlank()) {
            arachnidToSave.setPhotoUrl("/img/default_arachnid.jpg");
        }
        log.debug("Added data to create: {}", arachnidToSave);
        arachnidRepository.save(arachnidToSave);
        log.debug("Arachnid has been saved: {}", arachnidToSave);

        return arachnidToSave.getId();
    }


    public Arachnid getArachnidById(Long id) {
        Arachnid arachnid = arachnidRepository.getById(id);
        log.debug("Arachnid data downloaded: {}", arachnid);
        return arachnid;
    }

    public List<Arachnid> getArachnidByGenus(Long genusId) {
        return arachnidRepository.getAllByGenusId(genusId);
    }

    public List<Arachnid> getArachnidByLifeStyle(Long lifeStyleId) {
        return arachnidRepository.getAllByLifeStyleId(lifeStyleId);
    }

    public List<Arachnid> getArachnidByLevelOfDifficulty(Long levelOfDifficultyId) {
        return arachnidRepository.getAllByLevelOfDifficultyId(levelOfDifficultyId);
    }
}
