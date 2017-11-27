/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lv.tele2ssc.gamescore.dto.UserListDto;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vitasava
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    
    @RequestMapping("/rest/api/users/search")
    @ResponseBody
    public List<UserListDto> userList(@RequestParam("term") String searchValue,Model model) {
        List<User> users=userService.findByPartialName(searchValue);
        List<UserListDto> output=new ArrayList();
        for (User usr:users){
            UserListDto dto=new UserListDto();
            dto.fillFromUser(usr);
            output.add(dto);
        }
        return output;
    }
    
}
