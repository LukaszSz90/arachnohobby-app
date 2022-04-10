package LukaszSz90.arachnohobbyapp.config;


import LukaszSz90.arachnohobbyapp.domain.model.*;
import LukaszSz90.arachnohobbyapp.domain.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class StartupDataLoader {

    private final ArachnidRepository arachnidRepository;
    private final GenusRepository genusRepository;
    private final LifeStyleRepository lifeStyleRepository;
    private final LevelOfDifficultyRepository levelOfDifficultyRepository;
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder passwordEncoder;


    @EventListener
    public void onStartupPrepareData(ContextRefreshedEvent event) {
        log.info("Loading startup data.");

        loadGenusData();
        loadLifeStyleData();
        loadLevelOfDifficultyData();
        loadArachnidData();
        loadUserData();
        ladUserDetailsData();

        log.info("Startup data loaded.");
    }


    private void loadUserData() {
        userRepository.save(User.builder()
                .username("user1@user.com")
                .password(passwordEncoder.encode("user1"))
                .active(true)
                .roles(Set.of("ROLE_USER"))
                .build());

        userRepository.save(User.builder()
                .username("admin1@admin.com")
                .password(passwordEncoder.encode("admin1"))
                .active(true)
                .roles(Set.of("ROLE_ADMIN"))
                .build());
    }

    private void ladUserDetailsData() {
        userDetailsRepository.save(UserDetails.builder()
                .user(userRepository.getUserByUsername("user1@user.com"))
                .pictureNameUrl("/img/default_user.jpg")
                .nickName("user")
                .breedingPeriod(LocalDate.of(2020,4,5))
                .livingLocalization("Cracow")
                .build());

        userDetailsRepository.save(UserDetails.builder()
                .user(userRepository.getUserByUsername("admin1@admin.com"))
                .pictureNameUrl("/img/default_user.jpg")
                .nickName("admin")
                .breedingPeriod(LocalDate.now())
                .livingLocalization("Wroclaw")
                .build());
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
                .genusName("Tliltocatl")
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
                        .lifeStyle(lifeStyleRepository.getById(2L))
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

        arachnidRepository.save(
                Arachnid.builder()
                        .species("Geniculata")
                        .genus(genusRepository.getById(2L))
                        .levelOfDifficulty(levelOfDifficultyRepository.getById(1L))
                        .lifeStyle(lifeStyleRepository.getById(1L))
                        .areaOfOccurrence("Brasil, South America")
                        .humidityMin("70")
                        .humidityMax("80")
                        .temperatureMin("21")
                        .temperatureMax("30")
                        .maxSize("20")
                        .temperament("Slow")
                        .venomForce("Week")
                        .description("Described in 1841 by Koch, one of the largest species in South America," +
                                " next to the genus Theraphosa, Lasiodora and Pamphobeteus.")
                        .photoUrl("https://sklep.arent.pl/24-large_default/acanthoscurria-geniculata.jpg")
                        .build());

        arachnidRepository.save(
                Arachnid.builder()
                        .species("Albopilosus")
                        .genus(genusRepository.getById(6L))
                        .levelOfDifficulty(levelOfDifficultyRepository.getById(1L))
                        .lifeStyle(lifeStyleRepository.getById(1L))
                        .areaOfOccurrence("Costa Rica, Central America")
                        .humidityMin("60")
                        .humidityMax("80")
                        .temperatureMin("22")
                        .temperatureMax("30")
                        .maxSize("15")
                        .temperament("Slow")
                        .venomForce("Week")
                        .description("Described in 1980 by Valerio, one of the most popular species from South America." +
                                " Reaches up to 7 cm in body length (BL).")
                        .photoUrl("https://sklep.arent.pl/282-large_default/brachypelma-tliltocatl-albopilosus-nicaragua.jpg")
                        .build());

    }

}
