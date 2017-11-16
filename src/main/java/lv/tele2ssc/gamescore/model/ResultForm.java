/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.model;

/**
 *
 * @author olgakarj
 */
public class ResultForm {
    private Long activityId;
    private String date;
    private Long team1Id;
    private Long team2Id;
    private Integer teamScore1Id;
    private Integer teamScore2Id;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Long team1Id) {
        this.team1Id = team1Id;
    }

    public Long getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Long team2Id) {
        this.team2Id = team2Id;
    }

    public Integer getTeamScore1Id() {
        return teamScore1Id;
    }

    public void setTeamScore1Id(Integer teamScore1Id) {
        this.teamScore1Id = teamScore1Id;
    }

    public Integer getTeamScore2Id() {
        return teamScore2Id;
    }

    public void setTeamScore2Id(Integer teamScore2Id) {
        this.teamScore2Id = teamScore2Id;
    }

    @Override
    public String toString() {
        return "ResultForm{" + "activityId=" + activityId + ", date=" + date + ", team1Id=" + team1Id + ", team2Id=" + team2Id + ", teamScore1Id=" + teamScore1Id + ", teamScore2Id=" + teamScore2Id + '}';
    }


    
    
}
