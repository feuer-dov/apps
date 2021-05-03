package  myapps.mybasketballleague.models;

public class Player {
    private int totalShots;
    private int madeShots;
    private int points;
    private int assists;
    private int turnovers;
    private int gamesPlayed;
    public String name;

    public Player(String name) {
        this.name = name;
        //note that the other int values default to 0, exactly what we want
    }

    //getters

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
    //setters

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
}
