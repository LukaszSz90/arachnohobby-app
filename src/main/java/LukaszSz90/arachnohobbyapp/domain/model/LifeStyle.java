package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "life_style")
@EqualsAndHashCode(of = "name")
public class LifeStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "lifeStyle", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Arachnid> arachnids;
}
