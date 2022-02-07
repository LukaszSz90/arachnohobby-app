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
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "breeding_period")
    private LocalDate breedingPeriod;

    @Column(name = "living_localisation")
    private String livingLocalisation;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name = "user_Id", insertable = false, updatable = false)
    private Long userId;
}
