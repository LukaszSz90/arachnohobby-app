package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "continent_of_occurrence")
@EqualsAndHashCode(of = "continent_name")
public class ContinentOfOccurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "continent_name")
    private String continentName;

    @OneToMany(mappedBy = "continent", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Arachnid> arachnids;

    @OneToMany(mappedBy = "continent", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<CountryOfOccurrence> country;
}
