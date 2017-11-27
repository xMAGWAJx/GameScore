/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import lv.tele2ssc.gamescore.config.ApplicationConstants;
import lv.tele2ssc.gamescore.model.Team;
import lv.tele2ssc.gamescore.model.User;
import lv.tele2ssc.gamescore.model.forms.TeamMemberActionForm;
import lv.tele2ssc.gamescore.model.forms.TeamRegistrationForm;
import lv.tele2ssc.gamescore.services.TeamService;
import lv.tele2ssc.gamescore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vitasava
 */
@Controller
public class ParticipantController {
    @Autowired
    TeamService teamService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping("/participant-list")
    public String participantList(Model model) {
        return allTeams(model);
    }
    @RequestMapping(value="/participant-list/teams",method = RequestMethod.GET)
    public String allTeams(Model model){
        List<Team> teams=teamService.findAll();
        teams.sort(new Comparator<Team>(){
            @Override
            public int compare(Team o1, Team o2) {
                return o1.getName().compareTo(o2.getName());
            }
            
        });       
        model.addAttribute("teams", teams);
        return "participant-list";
    }
    @RequestMapping(value="/participant-list/users",method = RequestMethod.GET)
    public String allUsers(Model model){
        List<User> users=userService.findAll();
        users.sort((User u1,User u2)->u1.getFullName().compareTo(u2.getFullName()));
        model.addAttribute("users", users);
        return "participant-list";
    }
    
    @RequestMapping(value="/participant-list/users/{userId}",method = RequestMethod.GET)
    public String userTeams(@PathVariable("userId") long userId,Model model){
        User user=userService.findById(userId);
        Set<Team> userTeams=Collections.emptySet();
        if (user!=null){
            userTeams=user.getTeams();           
        }
        model.addAttribute("teams", userTeams);
        model.addAttribute("user",user);
        return "participant-list";
    }
    
    @RequestMapping(value="/participant-list/teams/{teamId}",method = RequestMethod.GET )
    public String teamMembers(@PathVariable("teamId") long teamId,Model model){
        Team team=teamService.findById(teamId);
        Set<User> teamMembers=Collections.emptySet();
        if (team!=null){
            teamMembers=team.getUsers();            
        }
        model.addAttribute("members", teamMembers);
        model.addAttribute("team",team);
        model.addAttribute("newMember",new TeamMemberActionForm());
        return "team-member-list";
    }
    @RequestMapping(value="/participant-list/teams/add",method = RequestMethod.GET )
    public String addNewTeamEmpty(Model model)
    {
        model.addAttribute("teamData", new TeamRegistrationForm());
        return "participant-list-add-team";
    }
    @RequestMapping(value="/participant-list/teams/add",method = RequestMethod.POST )
    public String addNewTeam(@Valid @ModelAttribute("teamData") TeamRegistrationForm teamData,BindingResult bindingResult,Model model){
        Team newTeam=new Team();
        if (!bindingResult.hasErrors()){
            String newTeamName=teamData.getFullName().trim();
            Team existingTeam=teamService.findByName(newTeamName);
            if (existingTeam!=null){
                bindingResult.rejectValue("fullName", "-", "Team with this name already registered");
                return "participant-list-add-team";
            }
            User currentUser=userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            newTeam.setName(newTeamName);
            newTeam.setTeamAdmin(currentUser);
            newTeam=teamService.addNewTeam(newTeam);
        }
        return "redirect:/participant-list/teams/"+newTeam.getId();
    }
     @RequestMapping(value="/participant-list/teams/{id}/add-member",method = RequestMethod.POST )
     public String addNewTeamMember(@PathVariable("id") long teamId,@Valid @ModelAttribute("newMember") TeamMemberActionForm newMember,BindingResult bindingResult,Model model){
        Team team=teamService.findById(teamId);
        User currentUser=userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (!bindingResult.hasErrors() && team!=null && team.getTeamAdmin().getId()==currentUser.getId()){
            User newMemberUser=userService.findById(newMember.getUserId());
            team.getUsers().add(newMemberUser);
            teamService.save(team);            
        }else{
            bindingResult.rejectValue("userId", "Not valid user value or does not have proper access");
        }
        return "redirect:/participant-list/teams/"+teamId;
    }
     @RequestMapping(value="/participant-list/teams/{id}/remove-member/{userId}",method = RequestMethod.GET )
     public String removeTeamMember(@PathVariable("id") long teamId,@PathVariable("userId") long userId,Model model){
        Team team=teamService.findById(teamId);
        User currentUser=userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (team!=null && team.getTeamAdmin().getId()==currentUser.getId()){
            User removeMember=userService.findById(userId);
            team.getUsers().remove(removeMember);
            teamService.save(team);          
       
        }
        return "redirect:/participant-list/teams/"+teamId;
    }
}
