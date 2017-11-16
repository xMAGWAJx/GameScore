/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.services;

import lv.tele2ssc.gamescore.config.ApplicationConstants;
import lv.tele2ssc.gamescore.model.Role;
import lv.tele2ssc.gamescore.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitasava
 */
@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    
    public Role findNewUserDefaultRole(){
        return roleRepository.findByName(ApplicationConstants.ROLE_USER);
    }
}
