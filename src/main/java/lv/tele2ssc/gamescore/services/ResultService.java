/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.services;

import java.util.Date;
import java.util.List;
import lv.tele2ssc.gamescore.model.Result;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.repositories.ResultRepository;
import lv.tele2ssc.gamescore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vitasava
 */
@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    
    
    public List<Result> findAll(){
        return (List<Result>)resultRepository.findAll();
    }
    public Boolean addNewResult(Result result){
       
        resultRepository.save(result);
        
        return true;
    }
}
