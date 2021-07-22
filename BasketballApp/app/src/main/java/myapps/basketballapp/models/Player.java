package myapps.basketballapp.models;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    int totalPoints;
    int totalAssists;
    int totalRebounds;
    int totalTurnovers;
    int shotsTaken;
    int shotsMade;
    String fgPercentage;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public int getShotsTaken() {
        return shotsTaken;
    }

    public int getShotsMade() {
        return shotsMade;
    }

    public int getTotalRebounds() {
        return totalRebounds;
    }

    public int getTotalTurnovers() {
        return totalTurnovers;
    }

    public String getFgPercentage() {
        double fgPercentageDouble = 0;
        if(shotsTaken > 0){
            fgPercentageDouble = ((double) shotsMade / shotsTaken) * 100.0;
            fgPercentage = "%" + String.format("%.02f", fgPercentageDouble);
        }
        else{
            fgPercentage = "N/A";
        }

        return fgPercentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    public void setShotsTaken(int shotsTaken) {
        this.shotsTaken = shotsTaken;
    }

    public void setShotsMade(int shotsMade) {
        this.shotsMade = shotsMade;
    }

    public void addPoints(int points){
        this.totalPoints += points;
        this.shotsMade++;
        this.shotsTaken++;
    }

    public void addAssist(){
        this.totalAssists++;
    }

    public void addRebound(){
        this.totalRebounds++;
    }

    public void addShotMissed(){
        this.shotsTaken++;
    }

    public void addTurnover(){
        this.totalTurnovers++;
    }
}
