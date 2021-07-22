package  myapps.mybasketballleague.models;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class Player implements Parcelable {
    private int totalShots;
    private int madeShots;
    private int points;
    private int assists;
    private int turnovers;
    private int gamesPlayed;
    private Team team;
    private String number;

    public String name;

    public Player(String name) {
        this.name = name;
        //note that the other int values default to 0, exactly what we want
    }

    //getters

    protected Player(Parcel in) {
        totalShots = in.readInt();
        madeShots = in.readInt();
        points = in.readInt();
        assists = in.readInt();
        turnovers = in.readInt();
        gamesPlayed = in.readInt();
        team = in.readParcelable(Team.class.getClassLoader());
        number = in.readString();
        name = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public double getPPG(){
        double ppg = ((double)points / gamesPlayed);
        return ppg;
    }

    public double getAPG(){
        double apg = ((double)assists / gamesPlayed);
        return apg;
    }

    public double getTurnoversPerGame(){
        double tpg = ((double)turnovers / gamesPlayed);
        return tpg;
    }

    public double getFgPercentage(){
        double fgp = ((double)madeShots / totalShots) * 100;
        return fgp;
    }

    public String getName(){
        return name;
    }

    public int getTotalShots(){
        return totalShots;
    }


    public int getMadeShots() {
        return madeShots;
    }

    public int getAssists() {
        return assists;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public int getPoints() {
        return points;
    }

    public Team getTeam(){
        return this.team;
    }

    public int getGamesPlayed(){
        return this.gamesPlayed;
    }
    //setters

    public void setTeam(Team team){
        this.team = team;
    }
    public void setPoints(int points){
        this.points = points;
    }

    public void setGamesPlayed(int gamesPlayed){
        this.gamesPlayed = gamesPlayed;
    }
    public void twoPtShotMade(){
        this.totalShots++;
        this.madeShots++;
        this.points += 2;
    }

    public void twoPtShotMissed(){
        this.totalShots++;
    }

    public void assistMade(){
        this.assists++;
    }

    public void turnoverMade(){
        this.turnovers++;
    }

    public void gamePlayed(){
        this.gamesPlayed++;
    }

    public void setNumber(String number){
        int numberInteger = Integer.parseInt(number);

        if(numberInteger >= 0 && numberInteger <= 99){
            this.number = number;
        }
    }
    public static Comparator<Player> ppgComparator = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            int p1Int = 0;
            int p2Int = 1;
            if (p1.getPPG() >= p2.getPPG()){
                p1Int = 1;
                p2Int = 0;
            }
            return p2Int - p1Int; //if p1s int is greater, the return is negative and p1 is placed before p2
        }
    };

    public static Comparator<Player> apgComparator = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            int p1Int = 0;
            int p2Int = 1;
            if (p1.getAPG() >= p2.getAPG()){
                p1Int = 1;
                p2Int = 0;
            }
            return p2Int - p1Int; //if p1s int is greater, the return is negative and p1 is placed before p2
        }
    };

    public static Comparator<Player> tpgComparator = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            int p1Int = 0;
            int p2Int = 1;
            if (p1.getTurnoversPerGame() >= p2.getTurnoversPerGame()){
                p1Int = 1;
                p2Int = 0;
            }
            return p2Int - p1Int; //if p1s int is greater, the return is negative and p1 is placed before p2
        }
    };

    public static Comparator<Player> fgpComparator = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            int p1Int = 0;
            int p2Int = 1;
            if (p1.getFgPercentage() >= p2.getFgPercentage()){
                p1Int = 1;
                p2Int = 0;
            }
            return p2Int - p1Int; //if p1s int is greater, the return is negative and p1 is placed before p2
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalShots);
        dest.writeInt(madeShots);
        dest.writeInt(points);
        dest.writeInt(assists);
        dest.writeInt(turnovers);
        dest.writeInt(gamesPlayed);
        dest.writeParcelable(team, flags);
        dest.writeString(number);
        dest.writeString(name);
    }
}
