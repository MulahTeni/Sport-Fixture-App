/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fikstur;

import java.io.Serializable;

/**
 *
 * @author mtpc
 */
public class Team implements Serializable{
    private String teamName;
    private int teamAverage;
    private int teamPoint;
    private int teamWins;
    private int teamLosses;
    private int teamDraws;

    public Team(String teamName) {
        this.teamName = teamName;
        this.teamAverage = 0;
        this.teamPoint = 0;
        this.teamWins = 0;
        this.teamLosses = 0;
        this.teamDraws = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamAverage() {
        return teamAverage;
    }

    public int getTeamPoint() {
        return teamPoint;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public int getTeamLosses() {
        return teamLosses;
    }

    public int getTeamDraws() {
        return teamDraws;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    private void adjTeamAverage(int teamNewAverage) {
        this.teamAverage += teamNewAverage;
    }

    private void adjTeamPoint(int teamNewPoint) {
        this.teamPoint += teamNewPoint;
    }

    private void adjTeamWins(int goalDiff, int f) {
        this.teamWins += f;
        adjTeamAverage(goalDiff);
        adjTeamPoint(f * 3);
    }
    
    private void adjTeamLosses(int goalDiff, int f) {
        this.teamLosses += f;
        adjTeamAverage(goalDiff);
    }

    private void adjTeamDraws(int f) {
        this.teamDraws += f;
        adjTeamPoint(f);
    }
    
    public void adjTeamWinBay() {
        this.teamWins += 1;
        adjTeamPoint(3);
    }
    
    public void setTeamWinLoseDraw(int goalDiff, boolean flag) {
        if (flag) {
            if (goalDiff > 0) adjTeamWins(goalDiff, 1);
            else if (goalDiff < 0) adjTeamLosses(goalDiff, 1);
            else adjTeamDraws(1);
            return;
        }
        if (goalDiff > 0) adjTeamWins(-goalDiff, -1);
        else if (goalDiff < 0) adjTeamLosses(-goalDiff, -1);
        else adjTeamDraws(-1);
    }
    
    public void setTeamWins(int teamWins) {
        this.teamWins = teamWins;
    }

    public void setTeamLosses(int teamLosses) {
        this.teamLosses = teamLosses;
    }

    public void setTeamAverage(int teamAverage) {
        this.teamAverage = teamAverage;
    }

    public void setTeamPoint(int teamPoint) {
        this.teamPoint = teamPoint;
    }

    public void setTeamDraws(int teamDraws) {
        this.teamDraws = teamDraws;
    }
    
    public Team deepCopy() {
        Team copy = new Team(this.getTeamName());
        copy.setTeamAverage(this.getTeamAverage());
        copy.setTeamPoint(this.getTeamPoint());
        copy.setTeamWins(this.getTeamWins());
        copy.setTeamLosses(this.getTeamLosses());
        copy.setTeamDraws(this.getTeamDraws());
        return copy;
    }
}