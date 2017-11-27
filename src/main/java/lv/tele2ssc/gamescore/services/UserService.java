/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.services;

import java.util.List;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.repositories.RoleRepository;
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
    
     @Autowired
    private RoleRepository roleRepository;
    
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
    public List<User> findByPartialName(String partialName){
        List<User> list1=userRepository.findByFullNameContainingIgnoreCase(partialName);
        List<User> list2=userRepository.findByEmailContainingIgnoreCase(partialName);
        for (User usr: list2){
            if (!list1.contains(usr)){
                list1.add(usr);
            }
        }
        list1.sort((User u1,User u2)->u1.getFullName().compareTo(u2.getFullName()));
        return list1;
    }
    
}
