/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fikstur;

import java.util.Comparator;

/**
 *
 * @author mtpc
 */
public class SortTeams implements Comparator<Team> {
    @Override
    public int compare(Team t1, Team t2) {
        // stuff
        if (t2.getTeamPoint() == t1.getTeamPoint())
            return t2.getTeamAverage() - t1.getTeamAverage();
        return t2.getTeamPoint() - t1.getTeamPoint();
    }
    
}
