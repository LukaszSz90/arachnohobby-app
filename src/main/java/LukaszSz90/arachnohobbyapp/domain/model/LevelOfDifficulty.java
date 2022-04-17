package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "level_of_difficulty")
@EqualsAndHashCode(of = "name")
public class LevelOfDifficulty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "levelOfDifficulty", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Arachnid> arachnids;

}
