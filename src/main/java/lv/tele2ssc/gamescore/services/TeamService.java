/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.services;

import java.util.List;
import lv.tele2ssc.gamescore.model.Team;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.repositories.TeamRepository;
import lv.tele2ssc.gamescore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitasava
 */
@Service
public class TeamService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;
    
    
    
    public Team findByName(String name){
        return teamRepository.findByName(name); 
    }
    public List<Team> findByUser(User user){
        List<Team> participant=teamRepository.findByUser(user);
        List<Team> owner=teamRepository.findTeamsWhereUserIsAdmin(user);
        for (Team team: owner){
            if (!participant.contains(team)){
                participant.add(team);
            }
            
        }
        return participant;   
    }
    public List<Team> findAll(){
        return (List<Team>)teamRepository.findAll();
    }

    public Team findById(Long team1Id) {
        return teamRepository.findOne(team1Id);
    }
    
    public List<Team> findAllExceptUser(User user){
        return teamRepository.findAllExceptUser(user);   
    }
    
    public Team addNewTeam(Team newTeam){
        return teamRepository.save(newTeam);
    }
    public void save(Team team){
        teamRepository.save(team);
    }
}
