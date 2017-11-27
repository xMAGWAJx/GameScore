/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.model.forms;

import java.io.Serializable;
import javax.persistence.Column;
import lv.tele2ssc.gamescore.model.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 *
 * @author vitasava
 */
public class TeamRegistrationForm implements Serializable {
    @NotEmpty(message = "Full name field may not be empty")       
    private String fullName;
    

    public TeamRegistrationForm() {
    }
   

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
