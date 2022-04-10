package LukaszSz90.arachnohobbyapp.domain.repository;

import LukaszSz90.arachnohobbyapp.domain.model.LevelOfDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LevelOfDifficultyRepository extends JpaRepository<LevelOfDifficulty,Long> {

    boolean existsByName(String levelName);


}
