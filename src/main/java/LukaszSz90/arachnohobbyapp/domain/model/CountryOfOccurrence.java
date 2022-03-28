package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "country_of_occurrence")
@EqualsAndHashCode(of = "country_name")
public class CountryOfOccurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany
    @JoinColumn(name = "continent_of_occurrence_id")
    @ToString.Exclude
    private ContinentOfOccurrence continent;
}
