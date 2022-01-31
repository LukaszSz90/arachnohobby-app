package LukaszSz90.arachnohobbyapp.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "tarantula")
public class Tarantula {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String genus;

    @Column(nullable = false, unique = true)
    private String species;



}
