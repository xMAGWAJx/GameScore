
package lv.tele2ssc.gamescore.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import jdk.nashorn.internal.objects.NativeArray;
import lv.tele2ssc.gamescore.model.Game;
import lv.tele2ssc.gamescore.model.GameStatus;
import lv.tele2ssc.gamescore.model.Result;
import lv.tele2ssc.gamescore.model.Results;
import lv.tele2ssc.gamescore.repositories.GameRepository;
import lv.tele2ssc.gamescore.repositories.ResultRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GameController {
    private static final Logger logger 
            = LoggerFactory.getLogger(GameController.class);
    
    @Autowired
    private ResultRepository resultRepository;
    
    @RequestMapping(path = "/game/{name}", method = RequestMethod.GET)
    public String page(@PathVariable String name, Model model) { 
//        Game g = new Game();
//        g.setPlace("New Building");
//        g.setState("COMPLETED");
        
        List<Result> db_result = resultRepository.findByActivity(name.toLowerCase());
        
        
        
        Map<Long, Results> results = new HashMap<>();
        for(Result r : db_result) {
            Results res = results.get(r.getTeam().getId());
            
            if (res == null) {
                res = new Results();
                res.setTeamName(r.getTeam().getName());
                results.put(r.getTeam().getId(), res);
            }
            
            res.setGameCount(res.getGameCount()+1);
            
            if (r.getResult() == GameStatus.WIN) {
                res.setWinCount(res.getWinCount()+1);
            }
            
            if (r.getResult() == GameStatus.LOSE) {
                res.setLossCount(res.getLossCount()+1);
            }
        }
        
        //logger.debug(results);
        //System.out.println(results);
        //group by price
        //Map<String, List<Results>> groupByTeam = results.stream().collect(Collectors.groupingBy(Results::getTeamName));

        //System.out.println(groupByTeam);
                
        model.addAttribute("results", results.values());
        return name;
    }
    
}
