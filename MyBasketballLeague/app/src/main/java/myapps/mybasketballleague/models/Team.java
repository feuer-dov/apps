package  myapps.mybasketballleague.models;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players;
    private String name;
    private int nofPlayers;

    public Team(String name){
        this.name = name;
        players = new ArrayList<>(15);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getTeam(){
        return players;
    }
    public void addPlayer(Player player){
        if(nofPlayers <= 15){ // roster maximum of 15
            nofPlayers++;

            players.add(player);
        }

    }
}
