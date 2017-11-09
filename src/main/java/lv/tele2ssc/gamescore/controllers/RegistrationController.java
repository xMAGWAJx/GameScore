/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import javax.validation.Valid;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vitasava
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())) { 
            bindingResult.rejectValue("passwordMismatch","-", "Password does not match");
            return "register";
        }
        
        if (userService.findByEmail(user.getEmail())!=null) {
            bindingResult.rejectValue("emailError","-", "User with this email already registered");
            return "register";
        }
        userService.addNewUser(user);
        return "login";
    }
}
