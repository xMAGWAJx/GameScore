/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import lv.tele2ssc.gamescore.model.Activity;
import lv.tele2ssc.gamescore.model.Game;
import lv.tele2ssc.gamescore.model.Result;
import lv.tele2ssc.gamescore.model.ResultForm;
import lv.tele2ssc.gamescore.model.Team;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.services.ActivityService;
import lv.tele2ssc.gamescore.services.GameService;
import lv.tele2ssc.gamescore.services.ResultService;
import lv.tele2ssc.gamescore.services.TeamService;
import lv.tele2ssc.gamescore.services.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zansdzan
 */
@Controller
public class ResultController {
    
    private static final Logger logger = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    private ResultService resultService;

    @Autowired
    private TeamService teamService;
    
    @Autowired
    private GameService gameService;

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
    public String addResult(@ModelAttribute("result") ResultForm result, BindingResult bindingResult, Model model) {
        logger.warn("Uraa! {}",result);
        Activity activity = activityService.findById(result.getActivityId());
        Team team1 = teamService.findById(result.getTeam1Id());
        Game game = new Game();
        game.setActivity(activity);
        gameService.save(game);
        
        Set<Result>results = new HashSet<>();
        Result r1 = new Result();
        r1.setGame(game);
        r1.setTeam(team1);
        r1.setScore(result.getTeamScore1Id());
        results.add(r1);
        
        resultService.save(r1);
        
        if (activity.getSingle() == 0) {
            Team team2 = teamService.findById(result.getTeam2Id());
            Result r2 = new Result();
            r2.setGame(game);
            r2.setTeam(team2);
            r2.setScore(result.getTeamScore2Id());
            results.add(r2);
            resultService.save(r2);
        }
        
        game.setResults(results);
 
        return "redirect:/";
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

        ResultForm result = new ResultForm();
        model.addAttribute("result", result);
        return "add-result";
    }
}
