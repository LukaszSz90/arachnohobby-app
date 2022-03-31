package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "genus")
@EqualsAndHashCode(of = "genus_name")
public class Genus {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "genus_name")
    private String genusName;

    @OneToMany(mappedBy = "genus", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Arachnid> arachnids;
}
