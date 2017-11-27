package lv.tele2ssc.gamescore.repositories;

import java.util.List;
import lv.tele2ssc.gamescore.model.Team;
import lv.tele2ssc.gamescore.model.User;
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
    
    @Query("SELECT t FROM Team t WHERE ?1 member of t.users")
    List<Team> findByUser(User user);
    
    @Query("SELECT t FROM Team t WHERE ?1 not member of t.users")
    List<Team> findAllExceptUser(User user);
    
    @Query("SELECT t FROM Team t WHERE t.teamAdmin = ?1")
    List<Team> findTeamsWhereUserIsAdmin(User user);
    
//    @Query("INSERT INTO user_team (user_id, team_id) VALUES ('1', '1')")
//    Integer addUserToTeam(User user, Team team);
}
