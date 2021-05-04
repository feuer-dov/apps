package myapps.mybasketballleague.models;

public class Game {
    private Team team1;
    private Team team2;
    private int t1Score;
    private int t2Score;

    public Game(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        t1Score = 0;
        t2Score = 0;
    }

    public void twoPointerMade(Player player, Team team){
        player.twoPtShotMade();
        if(team == team1){
            t1Score += 2;
        }
        else{
            t2Score += 2;
        }

    }


}
