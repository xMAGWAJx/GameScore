/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.services;

import java.util.List;
import lv.tele2ssc.gamescore.model.Activity;
import lv.tele2ssc.gamescore.model.Result;
import lv.tele2ssc.gamescore.repositories.ActivityRepository;
import lv.tele2ssc.gamescore.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author olgakarj
 */
@Service
public class ActivityService {
    
    @Autowired
    
    private ActivityRepository activityRepository;
    
    public List<Activity> findAll(){
        return (List<Activity>)activityRepository.findAll();
    }
}
