/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.List;
import lv.tele2ssc.gamescore.model.Team;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.services.TeamService;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vitasava
 */
@Controller
public class UserProfileController {
    @Autowired
    TeamService teamService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value="/user/profile",method = RequestMethod.GET)
    public String listUserProfile(Model model) {
        User currentUser=userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        
        List<Team> userTeams=teamService.findByUser(currentUser);
        userTeams.sort((Team t1, Team t2)->t1.getName().compareTo(t2.getName()));
        model.addAttribute("teams", userTeams);
        model.addAttribute("user", currentUser);
        return "user-profile";
    }
    
}
