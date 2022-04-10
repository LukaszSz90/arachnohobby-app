package LukaszSz90.arachnohobbyapp.domain.repository;

import LukaszSz90.arachnohobbyapp.domain.model.Genus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenusRepository extends JpaRepository<Genus, Long> {

    @Query(value = "SELECT genusName FROM Genus g WHERE g.id = id")
    Genus getNameById(@Param("id") Long id);

    boolean existsByName(String genusName);
}
