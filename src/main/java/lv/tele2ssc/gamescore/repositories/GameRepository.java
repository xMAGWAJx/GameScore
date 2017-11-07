package lv.tele2ssc.gamescore.repositories;

import java.util.List;
import lv.tele2ssc.gamescore.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository works directly with a table.
 * It has common operation (like selection by id, saving, 
 * counting etc.) defined in CrudRepository already
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    @Override
    List<Game> findAll();
}