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
import lv.tele2ssc.gamescore.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zansdzan
 */
@Controller
public class ResultController {
    @Autowired
    private ResultService resultService;
    
    @RequestMapping("/novus")
    public String page(Model model) {
        List<Activity> novusResult=new ArrayList<>();
        
        model.addAttribute("attribute", "value");
        return "novus";
    }
    
    @RequestMapping("/add-result")
    public String addResult(@Valid Result result,Model model) {
        
        
       // resultService.addNewResult(result);
        return "add-result";
    }
    
}
