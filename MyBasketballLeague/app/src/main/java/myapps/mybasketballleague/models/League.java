package myapps.mybasketballleague.models;

import java.util.ArrayList;
import java.util.Collections;

public class League {
    private ArrayList<Team> teams;
    private String name;
    private int nofTeams;
    public League(String name){
        this.name = name;
        teams = new ArrayList<>();
    }

    public ArrayList<Team> getTeams(){
        return this.teams;
    }
    public void addTeam(Team team){
        teams.add(team);
        this.nofTeams++;
    }

    public ArrayList<Player> getPlayers(){
        ArrayList<Player> players= new ArrayList<>();
        for(Team team: teams){
            for(Player player: team.getTeam()){
                players.add(player);
            }
        }
        return players;
    }
    public ArrayList<Player> getPPGSorted(){
        ArrayList<Player> players= this.getPlayers();
        Collections.sort(players, Player.ppgComparator);
        return players;
    }

    public ArrayList<Player> getAPGSorted() {
        ArrayList<Player> players= this.getPlayers();
        Collections.sort(players, Player.apgComparator);
        return players;
    }//descending order

    public ArrayList<Player> getTurnoversPerGameSorted(){
        ArrayList<Player> players= this.getPlayers();
        Collections.sort(players, Player.tpgComparator);
        return players;
    }

    public ArrayList<Player> getFieldGoalPercentageSorted(){
        ArrayList<Player> players= this.getPlayers();
        Collections.sort(players, Player.fgpComparator);
        return players;
    }
}
