/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.services;

import java.util.List;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitasava
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User findByEmail(String email){
        return userRepository.findByEmail(email); 
    }
    public User findById(long id){
        return userRepository.findOne(id);
    }
    public Boolean addNewUser(User user){
        userRepository.save(user);
        
        return true;
    }
    public List<User> findAll(){
        return (List<User>)userRepository.findAll();
    }
    
}
