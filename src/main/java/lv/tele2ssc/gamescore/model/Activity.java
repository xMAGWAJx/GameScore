package lv.tele2ssc.gamescore.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // marking class as an entity (mapped to DB table)
@Table(name = "activity") // table should have specific name
public class Activity implements Serializable {
    /**
     * id of the entity
     */
    @Id // required to mark a field as primary key
    @GeneratedValue // primary key is autoincrement
    @Column(name = "id") // column in the table should have specified name
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return name;
    }

    public void setActivity(String name) {
        this.name = name;
    }
}
