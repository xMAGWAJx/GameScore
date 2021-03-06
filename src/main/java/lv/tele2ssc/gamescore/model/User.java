package lv.tele2ssc.gamescore.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity // marking class as an entity (mapped to DB table)
@Table(name = "user") // table should have specific name
public class User implements Serializable {
    
    /**
     * id of the entity
     */
    @Id // required to mark a field as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // primary key is autoincrement
    @Column(name = "id") // column in the table should have specified name
    private Long id;
    
    @Column(name = "full_name")
    @NotEmpty
    private String fullName;
    
    @Email // validation column's value should be a vaild email
    @NotEmpty
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    @Length(min = 5)
    private String password;
    
    @Transient
    @Length(min = 5)
    private String passwordConfirm;
    
    
    @ManyToMany // many-to-many relationship
    @JoinTable(name="user_role", // middle table's name  
            joinColumns = @JoinColumn(name = "user_id"), // column in middle table for User id
            inverseJoinColumns = @JoinColumn(name = "role_id")) // column in middle table for Role id
    private Set<Role> roles;
    
    @ManyToMany // many-to-many relationship
    @JoinTable(name="user_team", // middle table's name  
            joinColumns = @JoinColumn(name = "user_id"), // column in middle table for User id
            inverseJoinColumns = @JoinColumn(name = "team_id")) // column in middle table for Role id
    private Set<Team> teams;
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeam(Team team) {
        this.teams.add(team);
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

}

