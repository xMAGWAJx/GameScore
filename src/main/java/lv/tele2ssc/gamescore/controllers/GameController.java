
package lv.tele2ssc.gamescore.controllers;

import java.util.Collections;
import java.util.List;
import lv.tele2ssc.gamescore.model.Game;
import lv.tele2ssc.gamescore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GameController {
    
    @Autowired
    private GameRepository gameRepository;
    
    @RequestMapping(path = "/game/{name}", method = RequestMethod.GET)
    public String page(@PathVariable String name, Model model) { 
//        Game g = new Game();
//        g.setPlace("New Building");
//        g.setState("COMPLETED");
        
        List<Game> games = gameRepository.findByActivity(name.toLowerCase());
        model.addAttribute("games", games);
        return "football";
    }
    
}
