package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "arachnid")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = {"name"})
@ToString
public class Arachnid {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String species;

    private String temperament;

    @Column(name = "temperature_min")
    private String temperatureMin;

    @Column(name = "temperature_max")
    private String temperatureMax;

    @Column(name = "humidity_min")
    private String humidityMin;

    @Column(name = "humidity_max")
    private String humidityMax;

    @Column(name = "venom_force")
    private String venomForce;

    private String describe;
    private String size;
    private String lifestyle;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "level_of_difficulty_id")
    @ToString.Exclude
    private LevelOfDifficulty levelOfDifficulty;

    @ManyToOne
    @JoinColumn(name = "genus_id",nullable = false)
    @ToString.Exclude
    private Genus genus;

    @ManyToOne
    @JoinColumn(name = "life_style_id",nullable = false)
    @ToString.Exclude
    private LifeStyle lifeStyle;

    @ManyToOne
    @JoinColumn(name = "continent_of_occurrence_id",nullable = false)
    @ToString.Exclude
    private ContinentOfOccurrence continent;
}
