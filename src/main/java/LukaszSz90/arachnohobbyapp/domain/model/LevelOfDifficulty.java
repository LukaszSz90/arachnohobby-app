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
@EqualsAndHashCode(of = "level_name")
public class LevelOfDifficulty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "level_name")
    private String levelName;

    @OneToMany(mappedBy = "levelOfDifficulty", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Arachnid> arachnids;

}
