package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users_details")
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "user")
@EqualsAndHashCode(of = {"user","userId"})
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_nick")
    private String userNick;

    @Column(name = "breeding_period")
    private LocalDate breedingPeriod;

    @Column(name = "living_localisation")
    private String livingLocalisation;

    @OneToOne
    private User user;

    @Column(insertable = false, updatable = false)
    private Long userId;
}
