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
public class UserRegistrationForm implements Serializable {
    @NotEmpty(message = "Full name field may not be empty")       
    private String fullName;
    @NotEmpty(message = "Email field may not be empty")
    @Email
    private String email;
    @Length(min = 5,message = "Password should be at least 5 characters long")
    private String password;
    @Length(min = 5,message = "Password should be at least 5 characters long")
    private String passwordConfirm;
    
    private String passwordMismatch;
    private String duplicateEmail;

    public UserRegistrationForm() {
    }

    public String getPasswordMismatch() {
        return passwordMismatch;
    }

    public void setPasswordMismatch(String passwordMismatch) {
        this.passwordMismatch = passwordMismatch;
    }

    public String getDuplicateEmail() {
        return duplicateEmail;
    }

    public void setDuplicateEmail(String duplicateEmail) {
        this.duplicateEmail = duplicateEmail;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

}
