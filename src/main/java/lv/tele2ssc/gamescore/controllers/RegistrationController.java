/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lv.tele2ssc.gamescore.model.Role;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.model.forms.UserRegistrationForm;
import lv.tele2ssc.gamescore.services.RoleService;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    RoleService roleService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("user", new UserRegistrationForm());
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") UserRegistrationForm user, BindingResult bindingResult, Model model, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            bindingResult.rejectValue("password", "-", "Password does not match");
            return "register";
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            bindingResult.rejectValue("email", "-", "User with this email already registered");
            return "register";
        }

        User newUser = new User();
        Role role = roleService.findNewUserDefaultRole();
        HashSet<Role> roleSet = new HashSet<Role>();
        roleSet.add(role);

        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(roleSet);
        userService.addNewUser(newUser);
        try {
            request.login(user.getEmail(), user.getPassword());           
        } catch (Exception ex) {
        }
        return "redirect:/login";
    }
}
