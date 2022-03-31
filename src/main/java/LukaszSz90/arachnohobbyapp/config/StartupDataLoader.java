package LukaszSz90.arachnohobbyapp.config;


import LukaszSz90.arachnohobbyapp.domain.model.Arachnid;
import LukaszSz90.arachnohobbyapp.domain.model.Genus;
import LukaszSz90.arachnohobbyapp.domain.model.LevelOfDifficulty;
import LukaszSz90.arachnohobbyapp.domain.model.LifeStyle;
import LukaszSz90.arachnohobbyapp.domain.repository.ArachnidRepository;
import LukaszSz90.arachnohobbyapp.domain.repository.GenusRepository;
import LukaszSz90.arachnohobbyapp.domain.repository.LevelOfDifficultyRepository;
import LukaszSz90.arachnohobbyapp.domain.repository.LifeStyleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupDataLoader {

    private final ArachnidRepository arachnidRepository;
    private final GenusRepository genusRepository;
    private final LifeStyleRepository lifeStyleRepository;
    private final LevelOfDifficultyRepository levelOfDifficultyRepository;

    @EventListener
    public void onStartupPrepareData(ContextRefreshedEvent event) {
        log.info("Loading startup data.");

        loadGenusData();
        loadLifeStyleData();
        loadLevelOfDifficultyData();
        loadArachnidData();

        log.info("Startup data loaded.");
    }

    private void loadGenusData() {
        genusRepository.save(Genus.builder()
                .genusName("Avicularia")
                .build());

        genusRepository.save(Genus.builder()
                .genusName("Acanthoscurria")
                .build());

        genusRepository.save(Genus.builder()
                .genusName("Nhandu")
                .build());

        genusRepository.save(Genus.builder()
                .genusName("Hysterocrates")
                .build());

        genusRepository.save(Genus.builder()
                .genusName("Psalmopeus")
                .build());

        genusRepository.save(Genus.builder()
                .genusName("Theraphosa")
                .build());
    }

    private void loadLifeStyleData() {
        lifeStyleRepository.save(LifeStyle.builder()
                .name("grounded")
                .build());

        lifeStyleRepository.save(LifeStyle.builder()
                .name("arboreal")
                .build());

        lifeStyleRepository.save(LifeStyle.builder()
                .name("undergrounded")
                .build());
    }

    private void loadLevelOfDifficultyData() {
        levelOfDifficultyRepository.save(LevelOfDifficulty.builder()
                .levelName("beginner")
                .build());

        levelOfDifficultyRepository.save(LevelOfDifficulty.builder()
                .levelName("intermediate")
                .build());

        levelOfDifficultyRepository.save(LevelOfDifficulty.builder()
                .levelName("advanced")
                .build());
    }

    private void loadArachnidData() {
        arachnidRepository.save(
                Arachnid.builder()
                        .species("Versicolor")
                        .genus(genusRepository.getById(1L))
                        .levelOfDifficulty(levelOfDifficultyRepository.getById(1L))
                        .lifeStyle(lifeStyleRepository.getById(1L))
                        .areaOfOccurrence("The Lesser Antilles, Martinique island")
                        .humidityMin("75")
                        .humidityMax("85")
                        .temperatureMin("23")
                        .temperatureMax("28")
                        .maxSize("16")
                        .temperament("Fast")
                        .venomForce("Week")
                        .description("Described in 1837 by Walckenaer, representative of the genus Caribena" +
                                " (ex. Avicularia). One of the most beautiful tarantulas in the world," +
                                " occurring in South America.")
                        .photoUrl("https://sklep.arent.pl/367-large_default/caribena-versicolor-l2.jpg")
                        .build());

    }

}
