/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.services;

import lv.tele2ssc.gamescore.model.Game;
import lv.tele2ssc.gamescore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author olgakarj
 */
@Service
public class GameService {
    @Autowired GameRepository gameRepository;
    
    public void save (Game game) {
        gameRepository.save(game);
    }
}
