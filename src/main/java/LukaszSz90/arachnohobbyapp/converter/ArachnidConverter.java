package LukaszSz90.arachnohobbyapp.converter;

import LukaszSz90.arachnohobbyapp.domain.model.Arachnid;
import LukaszSz90.arachnohobbyapp.domain.model.LevelOfDifficulty;
import LukaszSz90.arachnohobbyapp.domain.repository.GenusRepository;
import LukaszSz90.arachnohobbyapp.domain.repository.LevelOfDifficultyRepository;
import LukaszSz90.arachnohobbyapp.domain.repository.LifeStyleRepository;
import LukaszSz90.arachnohobbyapp.web.command.ArachnidCommand;
import lombok.RequiredArgsConstructor;

import javax.persistence.Converter;

@Converter @RequiredArgsConstructor
public class ArachnidConverter {
    private final GenusRepository genusRepository;
    private final LifeStyleRepository lifeStyleRepository;
    private final LevelOfDifficultyRepository levelOfDifficultyRepository;


    public Arachnid from(ArachnidCommand command) {
        return Arachnid.builder()
                .species(command.getSpecies())
                .temperament(command.getTemperament())
                .temperatureMin(command.getTemperatureMin())
                .temperatureMax(command.getTemperatureMax())
                .humidityMin(command.getHumidityMin())
                .humidityMax(command.getHumidityMax())
                .venomForce(command.getVenomForce())
                .description(command.getDescription())
                .maxSize(command.getMaxSize())
                .areaOfOccurrence(command.getAreaOfOccurrence())
                .levelOfDifficulty(levelOfDifficultyRepository.getById(command.getGenusId()))
                .genus(genusRepository.getById(command.getGenusId()))
                .build();
    }
}
