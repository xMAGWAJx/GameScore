/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.List;
import lv.tele2ssc.gamescore.model.Activity;
import lv.tele2ssc.gamescore.model.Result;
import lv.tele2ssc.gamescore.model.Team;
import lv.tele2ssc.gamescore.services.ActivityService;
import lv.tele2ssc.gamescore.services.ResultService;
import lv.tele2ssc.gamescore.services.TeamService;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author olgakarj
 */
@Controller
public class ActivityController {
    
    @Autowired
    private ActivityService activityService;
    @Autowired
    private TeamService teamService;
    
    @RequestMapping(path="/add-result", method=RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        List<Team> teams=teamService.findAll();
        List<Activity> activities = activityService.findAll();
        model.addAttribute("activities", activities);
        model.addAttribute("team", teams);
        return "add-result";
    }
    
    
    
}
