package myapps.basketballapp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class League implements Serializable {
    HashMap<String, Object> playerHashMap;
    String leagueName;

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.playerHashMap = new HashMap<>();
    }

    public HashMap<String, Object> getPlayerHashMap() {
        return playerHashMap;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public Player getPlayer(String playerName){
        return (Player) playerHashMap.get(playerName);
    }

    public ArrayList<Object> getPlayerArrayList(){
        ArrayList<Object> playerArrayList = new ArrayList<Object>(playerHashMap.values());
        return playerArrayList;
    }

    public ArrayList<String> getPlayerNameArrayList(){
        ArrayList<String> playerNameArrayList = new ArrayList<String>(playerHashMap.keySet());
        return playerNameArrayList;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void addPlayer(Player player){
        this.playerHashMap.put(player.getName(), player);
    }
}
