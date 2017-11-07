package lv.tele2ssc.gamescore.repositories;

import java.util.List;
import lv.tele2ssc.gamescore.model.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository works directly with a table.
 * It has common operation (like selection by id, saving, 
 * counting etc.) defined in CrudRepository already
 */
@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {
    //@Query("SELECT r FROM Result r WHERE r.game_id = ?1")
    //List<Result> findByGame_id(String game_id);
    @Override
    List<Result> findAll();
}