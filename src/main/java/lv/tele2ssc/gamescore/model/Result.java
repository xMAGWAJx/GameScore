package lv.tele2ssc.gamescore.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // marking class as an entity (mapped to DB table)
@Table(name = "result") // table should have specific name
public class Result implements Serializable {
    /**
     * id of the entity
     */
    @Id // required to mark a field as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // primary key is autoincrement
    @Column(name = "id") // column in the table should have specified name
    private Long id;
    
    @Column(name = "created_Date")
    private Timestamp createdDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
    
    //Win, Lose, Draft
    @Column(name = "result")
    @Enumerated(EnumType.STRING)
    private GameStatus result;
    
    @Column(name = "score")
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public GameStatus getResult() {
        return result;
    }

    public void setResult(GameStatus result) {
        this.result = result;
    }
    
    
    
}
