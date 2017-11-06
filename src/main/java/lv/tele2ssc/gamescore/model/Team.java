package lv.tele2ssc.gamescore.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // marking class as an entity (mapped to DB table)
@Table(name = "team") // table should have specific name
public class Team implements Serializable {
    /**
     * id of the entity
     */
    @Id // required to mark a field as primary key
    @GeneratedValue // primary key is autoincrement
    @Column(name = "id") // column in the table should have specified name
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "createdDate")
    private Timestamp createdDate;

    @ManyToMany // many-to-many relationship
    @JoinTable(name="user_team", // middle table's name  
            joinColumns = @JoinColumn(name = "user_id"), // column in middle table for User id
            inverseJoinColumns = @JoinColumn(name = "team_id")) // column in middle table for Role id
    private Set<User> users;
    
    @OneToMany(mappedBy = "team")
    private Set<Result> results;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Timestamp date) {
        this.createdDate = date;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
    
}
