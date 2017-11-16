/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.config;

import java.io.Serializable;
import java.util.Random;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;



@Component(value = "context")
@Scope("session")
public class UserContext implements Serializable {
      private User currentUser=new User();
      private String currentUserName="";
      @Autowired
      UserService userService;
      
      public User getUser(){
          Authentication auth= SecurityContextHolder.getContext().getAuthentication();
          User user = new User();          
          if (auth == null) {
              return user;
          }
          String email = auth.getName();
          
          if (!email.equals(this.currentUserName)) {  
              //refresh user name
              currentUser=userService.findByEmail(email);         
          }
          currentUserName=email;
          return currentUser!=null?currentUser:user;
      }
    
}
