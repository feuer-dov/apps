package myapps.mybasketballleague.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class Game implements Parcelable {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;

    Player pgHome;
    Player sgHome;
    Player sfHome;
    Player pfHome;
    Player cHome;

    Player pgAway;
    Player sgAway;
    Player sfAway;
    Player pfAway;
    Player cAway;

    public Game(Team homeTeam, Team awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeScore = 0;
        awayScore = 0;
    }


    protected Game(Parcel in) {
        homeTeam = in.readParcelable(Team.class.getClassLoader());
        awayTeam = in.readParcelable(Team.class.getClassLoader());
        homeScore = in.readInt();
        awayScore = in.readInt();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public String getScore(){
        return homeTeam.getName() + " " + homeScore + ": " + awayTeam.getName() + " " + awayScore;
    }

    public int getHomeScore(){
        return homeScore;
    }

    public int getAwayScore(){
        return awayScore;
    }
    public Team getHomeTeam(){
        return homeTeam;
    }

    public Team getAwayTeam(){
        return awayTeam;
    }

    public Player getPgHome() {
        return pgHome;
    }

    public Player getSgHome() {
        return sgHome;
    }

    public Player getSfHome() {
        return sfHome;
    }

    public Player getPfHome() {
        return pfHome;
    }

    public Player getcHome() {
        return cHome;
    }

    public Player getPgAway() {
        return pgAway;
    }

    public Player getSgAway() {
        return sgAway;
    }

    public Player getSfAway() {
        return sfAway;
    }

    public Player getPfAway() {
        return pfAway;
    }

    public Player getcAway() {
        return cAway;
    }


    public void twoPointerMade(Player player){
        player.twoPtShotMade();
        if(player.getTeam() == homeTeam){
            homeScore += 2;
        }
        else{
            awayScore += 2;
        }
    }

    public void gameOver(){ //actions when the game ends; set winner and loser, and increments games played for every player
        if(homeScore > awayScore){
            homeTeam.addWin();
            awayTeam.addLoss();
        }
        else if(awayScore > homeScore){
            awayTeam.addWin();
            homeTeam.addLoss();
        } // if both these are false it's a tie and the game is not over

        for(Player player: homeTeam.getTeam()){
            player.gamePlayed();
        }

        for(Player player: awayTeam.getTeam()){
            player.gamePlayed();
        }
    }

    public void setPg(Player player){
        if(player.getTeam() == homeTeam){
            pgHome = player;
        }
        else{
            pgAway = player;
        }
    }

    public void setSg(Player player){
        if(player.getTeam() == homeTeam){
            sgHome = player;
        }
        else{
            sgAway = player;
        }
    }

    public void setSf(Player player){
        if(player.getTeam() == homeTeam){
            sfHome = player;
        }
        else{
            sfAway = player;
        }
    }

    public void setPf(Player player){
        if(player.getTeam() == homeTeam){
            pfHome = player;
        }
        else{
            pfAway = player;
        }
    }

    public void setC(Player player){
        if(player.getTeam() == homeTeam){
            cHome = player;
        }
        else{
            cAway = player;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(homeTeam, flags);
        dest.writeParcelable(awayTeam, flags);
        dest.writeInt(homeScore);
        dest.writeInt(awayScore);
    }
}
