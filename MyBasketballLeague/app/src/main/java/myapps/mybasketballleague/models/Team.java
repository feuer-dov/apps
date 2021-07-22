package  myapps.mybasketballleague.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Team implements Parcelable {
    private ArrayList<Player> players;
    private String name;
    private int nofPlayers;
    private int wins;
    private int losses;

    public Team(String name){
        this.name = name;
        players = new ArrayList<>(15);

        this.wins = 0;
        this.losses = 0;
    }

    protected Team(Parcel in) {
        players = in.createTypedArrayList(Player.CREATOR);
        name = in.readString();
        nofPlayers = in.readInt();
        wins = in.readInt();
        losses = in.readInt();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public String getName() {
        return name;
    }

    public ArrayList<Player> getTeam(){
        return players;
    }

    public void addWin(){
        this.wins++;
    }

    public void addLoss(){
        this.losses++;
    }

    public void addPlayer(Player player){
        if(nofPlayers <= 15){ // roster maximum of 15
            nofPlayers++;

            players.add(player);
            player.setTeam(this);
        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(players);
        dest.writeString(name);
        dest.writeInt(nofPlayers);
        dest.writeInt(wins);
        dest.writeInt(losses);
    }
}
