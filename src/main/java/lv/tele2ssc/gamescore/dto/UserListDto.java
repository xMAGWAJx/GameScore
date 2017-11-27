/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.dto;

import lv.tele2ssc.gamescore.model.User;

/**
 *
 * @author vitasava
 */
public class UserListDto {
     private Long id;
     private String fullName;
     private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void fillFromUser(User usr){
        this.email=usr.getEmail();
        this.fullName=usr.getFullName();
        this.id=usr.getId();
    }
     
}
