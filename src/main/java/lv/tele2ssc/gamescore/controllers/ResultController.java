/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;
import lv.tele2ssc.gamescore.model.Activity;
import lv.tele2ssc.gamescore.model.Result;
import lv.tele2ssc.gamescore.model.Team;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.services.ActivityService;
import lv.tele2ssc.gamescore.services.ResultService;
import lv.tele2ssc.gamescore.services.TeamService;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zansdzan
 */
@Controller
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;

    @RequestMapping("/novus")
    public String page(Model model) {
        List<Activity> novusResult = new ArrayList<>();

        model.addAttribute("attribute", "value");
        return "novus";
    }

    @RequestMapping(path = "/add-result", method = RequestMethod.POST)
    public String addResult(@Valid Result result, Model model) {

        return "add-result";
    }

    @RequestMapping(path = "/add-result", method = RequestMethod.GET)
    public String addResult(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.findByEmail(email);
        
        List<Team> userTeams = teamService.findByUser(currentUser);
        model.addAttribute("userTeams", userTeams);
        
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        List<Activity> activities = activityService.findAll();
        model.addAttribute("activities", activities);

        Result result = new Result();
        model.addAttribute("result", result);
        return "add-result";
    }
}
