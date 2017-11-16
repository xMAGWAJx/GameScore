package lv.tele2ssc.gamescore.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // marking class as an entity (mapped to DB table)
@Table(name = "activity") // table should have specific name
public class Activity implements Serializable {
    /**
     * id of the entity
     */
    @Id // required to mark a field as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // primary key is autoincrement
    @Column(name = "id") // column in the table should have specified name
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "rules")
    private String rules;
    
    @Column(name = "single")
    private int single;
    
    @OneToMany(mappedBy = "activity")
    private Set<Game> games;

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSingle() {
        return single;
    }

    public void setSingle(int single) {
        this.single = single;
    }
    
    
}
