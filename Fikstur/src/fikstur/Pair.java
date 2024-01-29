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
public class Pair implements Serializable{
    private final Team team1;
    private final Team team2;
    private int team1Goals;
    private int team2Goals;
    
    public Pair(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        team1Goals = -1;
        team2Goals = -1;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1Goals() {
        return team1Goals;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }

    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }

    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }
    
    
}
