/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.List;
import lv.tele2ssc.gamescore.model.Activity;
import lv.tele2ssc.gamescore.services.ActivityService;
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
    
    @RequestMapping(path="/add-result", method=RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        List<Activity> activities = activityService.findAll();
        model.addAttribute("activities", activities);
        return "add-result";
    }
    
}
