package lv.tele2ssc.gamescore.repositories;

import java.util.List;
import lv.tele2ssc.gamescore.model.Activity;
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
public interface ActivityRepository extends CrudRepository<Activity, Long> {
    @Override
    List<Activity> findAll();
    
    @Query("SELECT a FROM Activity a WHERE LOWER(a.name) = ?1")
    Activity findByName(String name);
}