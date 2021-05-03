package myapps.mybasketballleague.models;

import java.util.ArrayList;

public class League {
    private ArrayList<Team> teams;
    private String name;

    public League(String name){
        this.name = name;
    }

    public void addTeam(Team team){
        teams.add(team);
    }

    public ArrayList<Player> getPPGSorted(){
        ArrayList<Player> ppgList = new ArrayList<>();
        for(Team team: teams){
            ArrayList<Player> players = team.getTeam();
            for (Player player: players){

            }
        }
        return null;
    }
}
