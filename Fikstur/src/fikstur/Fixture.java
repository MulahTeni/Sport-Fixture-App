/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fikstur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mtpc
 */
public class Fixture implements Serializable{
    private final String fixtureName;
    private final int teamCount;
    private final int isBay;
    private List<Team> teamList;
    private final int weekCount;
    private final List<Week> weekList;
    private final int weeklyMatchCount; // bay included
    private int currentWeek;
    private int currentMatch;

    public Fixture(String fName, int teamCount, List<Team> teamList) {
        this.fixtureName = fName;
        this.isBay = teamCount % 2;
        this.teamList = teamList;
        this.teamCount = teamCount + this.isBay;
        this.weekCount = (this.teamCount - 1) * 2;
        this.weeklyMatchCount = this.teamCount / 2;
        this.weekList = new ArrayList<>();
        this.currentWeek = 0;
        this.currentMatch = 0;
        initWeeks2();
        //initWeeks();
        Functions.printWeekMatches(weekList);
    }
    
    private void initWeeks2() {
        if (isBay == 1) {
            Team bt = new Team("Bay");
            teamList.add(bt);
        }
        teamList = Functions.shuffleTeamList(teamList);
        
        List<Team> tmpTeamList = new ArrayList<>();
        tmpTeamList.addAll(teamList);
        tmpTeamList.remove(teamList.get(0));
        
        for(int i = 0; i < weekCount; ++i) {
            List<Pair> weekMatches = new ArrayList<>();
            if (i < weekCount / 2)
                weekMatches.add(new Pair(teamList.get(0), tmpTeamList.getLast()));
            else
                weekMatches.add(new Pair(tmpTeamList.getLast(), teamList.get(0)));
            
            for(int j = 0; j < weeklyMatchCount - 1; ++j) {
                if (i < weekCount / 2)
                    weekMatches.add(new Pair(tmpTeamList.get(j), tmpTeamList.get(tmpTeamList.size() - 2 - j)));
                else
                    weekMatches.add(new Pair(tmpTeamList.get(tmpTeamList.size() - 1 - j), tmpTeamList.get(j)));
            }
            Team tmp = tmpTeamList.removeFirst();
            tmpTeamList.addLast(tmp);
            weekList.add(new Week(weekMatches));
        }
    }
    
    private void initWeeks() {
        if (isBay == 1) {
            Team bt = new Team("Bay");
            teamList.add(bt);
        }
        
        List<List<Pair>> allTeamMatches = new ArrayList<>();
        for(int i = 0; i < teamCount - 1; ++i) {
            List<Pair> teamMatches = new ArrayList<>();
            for(int j = i + 1; j < teamCount; ++j) {
                Pair np = new Pair(teamList.get(i), teamList.get(j));
                teamMatches.add(np);
                //System.out.println("!!!t1 : " + np.getTeam1().getTeamName() + " t2: " + np.getTeam2().getTeamName());
            }
            allTeamMatches.add(teamMatches);
        }
        List<Week> weekListLast = new ArrayList<>();
        for(int i = 0; i < weekCount / 2; ++i) {
            Pair currentPair = allTeamMatches.get(0).get(0);
            Pair reversedPair = new Pair(currentPair.getTeam2(), currentPair.getTeam1());
            List<Pair> weekMatches = new ArrayList<>();
            List<Pair> weekMatchesReversed = new ArrayList<>();
            weekMatches.add(currentPair);
            weekMatchesReversed.add(reversedPair);
            Set<Team> playedTeams = new HashSet<>();
            Functions.DFS(1, teamCount, 0, weeklyMatchCount - 1, currentPair, allTeamMatches, playedTeams, weekMatches, weekMatchesReversed);
            Functions.printWeekMatch(weekMatches);
            Functions.removeElement(allTeamMatches, weekMatches);
            weekList.add(new Week(weekMatches));
            weekListLast.add(new Week(weekMatchesReversed));
        }
        weekList.addAll(weekListLast);
    }
    
    public int getTeamCount() {
        return teamCount;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public int getWeekCount() {
        return weekCount;
    }

    public List<Week> getWeekList() {
        return weekList;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public String getFixtureName() {
        return fixtureName;
    }

    public int getWeeklyMatchCount() {
        return weeklyMatchCount;
    }

    public int getCurrentMatch() {
        return currentMatch;
    }

    public void setCurrentWeek(int currentWeek) {
        this.currentWeek = currentWeek;
    }

    public void setCurrentMatch(int currentMatch) {
        this.currentMatch = currentMatch;
    }
}
