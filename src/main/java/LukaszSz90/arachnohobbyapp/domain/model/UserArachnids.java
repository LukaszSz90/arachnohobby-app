package LukaszSz90.arachnohobbyapp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_arachnid")
@AllArgsConstructor @NoArgsConstructor
@Builder @Data
@ToString(exclude = "user")
@EqualsAndHashCode(of = {"userId"})
public class UserArachnids {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String gender;

    @Column(name = "my_arachnid_name")
    private String myArachnidName;

    @Column(name = "last_feeding")
    private LocalDate lastFeeding;

    @Column(name = "actual_feeding")
    private LocalDate actualFeeding;

    @Column(name = "copulation_date")
    private LocalDate copulationDate;

//    @Column(name = "grow_date")
//    private List<LocalDate> growDate;

    @Column(name = "last_grow_date")
    private LocalDate lastGrowDate;

    @Column(name = "actual_grow_date")
    private LocalDate actualGrowDate;

    @Column(name = "actual_size")
    private String actualSize;

    @Column(name = "date_of_purchase")
    private LocalDate dateOfPurchase;

    @Column(name = "pics_url")
    private String picsUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
