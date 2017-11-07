package lv.tele2ssc.gamescore.repositories;

import lv.tele2ssc.gamescore.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository works directly with a table.
 * It has common operation (like selection by id, saving, 
 * counting etc.) defined in CrudRepository already
 */
@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    @Query("SELECT t FROM Team t WHERE t.name = ?1")
    Team findByName(String name);
}