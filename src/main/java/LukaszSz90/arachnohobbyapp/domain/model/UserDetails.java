package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users_profile")
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "user")
@EqualsAndHashCode(of = {"user","userId"})
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;
    private LocalDate breedingPeriod;
    private String livingLocalisation;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @Column(name = "user_Id", insertable = false, updatable = false)
    private Long userId;
}
