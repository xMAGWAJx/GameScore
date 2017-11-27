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
public class TeamMemberActionForm implements Serializable {
    //@NotEmpty(message = "User field cannot be empty")   
    public static enum ACTION {
        ADD,
        REMOVE
    };
    private ACTION memberAction;
    private long userId;
    
    //@NotEmpty
    private String userName;

    public TeamMemberActionForm() {
    }
   

    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ACTION getMemberAction() {
        return memberAction;
    }

    public void setMemberAction(ACTION memberAction) {
        this.memberAction = memberAction;
    }
    

}
