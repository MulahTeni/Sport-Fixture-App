/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fikstur;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author mtpc
 */
public class Functions {
    public static boolean DFS(int lastIndex, int teamCount, int matchesPicked, int weekMatchCount, Pair prevPair, List<List<Pair>> allTeamMatches, Set<Team> playedTeams, List<Pair> weekMatches, List<Pair> weekMatchesReversed) {
        if (matchesPicked == weekMatchCount) return true;
        Set<Team> tmpPlayedTeams = new HashSet<>();
        if (playedTeams != null) tmpPlayedTeams.addAll(playedTeams);
        tmpPlayedTeams.add(prevPair.getTeam1());
        tmpPlayedTeams.add(prevPair.getTeam2());
        
        for(int i = lastIndex; i < teamCount - 1; ++i) {
            List<Pair> teamMatches = allTeamMatches.get(i);
            if (teamMatches.isEmpty()) continue;
            Team team1 = teamMatches.get(0).getTeam1();
            //System.out.println("i : " + i + " team 1: " + team1.getTeamName());
            if (tmpPlayedTeams.contains(team1)) {
                //System.out.println("set contains : " + team1.getTeamName());
                continue;
            }
            for(int j = 0; j < teamMatches.size(); ++j) {
                Pair currentPair = teamMatches.get(j);
                //System.out.println("!!!! cP t1 : " + currentPair.getTeam1().getTeamName() + " t2 : " + currentPair.getTeam2().getTeamName());
                if (tmpPlayedTeams.contains(currentPair.getTeam2())) continue;
                boolean flag = DFS(i + 1, teamCount, matchesPicked + 1, weekMatchCount, currentPair, allTeamMatches, tmpPlayedTeams, weekMatches, weekMatchesReversed);
                if (flag) {
                    weekMatches.add(currentPair);
                    weekMatchesReversed.add(new Pair(currentPair.getTeam2(), currentPair.getTeam1()));
                    return true;
                }
                //System.out.println("Rejected\n");
            }
            
            
            
        }
        return false;
    }
    
    public static void printWeekMatches(List<Week> weekList) {
        int k = 0;
        for(Week w : weekList) {
            System.out.println("\nWeek " + ++k);
            for(int i = 0; i < w.getPairs().size(); ++i) {
                System.out.println("   Match " + (i + 1) + "\nTeam 1 : " + w.getPairs().get(i).getTeam1().getTeamName() + "\nTeam 2 : " + w.getPairs().get(i).getTeam2().getTeamName());
            }
        }
    }
    
    public static void printWeekMatch(List<Pair> pairList) {
        System.out.println();
        for(Pair p : pairList) {
            System.out.println("Removed : " + p.getTeam1().getTeamName() + " - " + p.getTeam2().getTeamName());
        }
    }
    
    public static void removeElement(List<List<Pair>> listListPair, List<Pair> pairlist) {
        for(List<Pair> listPair : listListPair) {
            listPair.removeAll(pairlist);
        }
    }
    
    private static int randomGoals() {
        Random rand = new Random();
        int num = rand.nextInt(54);
        System.out.println("sayı : " + num);
        if (num < 10) return 0;
        if (num < 18) return 1;
        if (num < 27) return 2;
        if (num < 33) return 3;
        if (num < 39) return 4;
        if (num < 44) return 5;
        if (num < 48) return 6;
        if (num < 51) return 7;
        if (num < 53) return 8;
                      return 9;
    }
    
    private static void adjustPoints(Pair currPair, int team1Goal, int team2Goal, boolean flag){
        currPair.getTeam1().setTeamWinLoseDraw(team1Goal - team2Goal, flag);
        currPair.getTeam2().setTeamWinLoseDraw(team2Goal - team1Goal, flag);
        if (!flag) {
            team1Goal = -1;
            team2Goal = -1;
        }
        currPair.setTeam1Goals(team1Goal);
        currPair.setTeam2Goals(team2Goal);
    }
    
    private static boolean checkBay(Team t1, Team t2) {
        if (t1.getTeamName().equalsIgnoreCase("bay")) {
            t2.adjTeamWinBay();
            JOptionPane.showMessageDialog(null, "Team " + t2.getTeamName() + " won by bay.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        if (t2.getTeamName().equalsIgnoreCase("bay")) {
            t1.adjTeamWinBay();
            JOptionPane.showMessageDialog(null, "Team " + t1.getTeamName() + " won by bay.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }
    
    private static int userTeamGoal(Team team1, Team team2) {
        int teamGoal;
        try {
                String numStr = JOptionPane.showInputDialog(team1.getTeamName() + " vs " + team2.getTeamName() + "\n" + team1.getTeamName() + " goals :");
                if (numStr == null || numStr.isEmpty() || numStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Operation cancelled.", "ERROR!", JOptionPane.ERROR_MESSAGE);
                    return -1;
                }
                    
                if ((teamGoal = Integer.parseInt(numStr)) < 0) throw new Exception("Goals can not be negative.");
                if (teamGoal > 9) throw new Exception("Goals can not be more than 9.");
                return teamGoal;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.", "ERROR!", JOptionPane.ERROR_MESSAGE);
                teamGoal = userTeamGoal(team1, team2);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
                teamGoal = userTeamGoal(team1, team2);
            }
        return teamGoal;
    }
    
    public static boolean playAMatch(Fixture fixture, int currentMatch, int currentWeek, boolean flag) {
        Pair currPair = fixture.getWeekList().get(currentWeek).getPairs().get(currentMatch);
        Team team1 = currPair.getTeam1();
        Team team2 = currPair.getTeam2();
        if (checkBay(team1, team2)) return false;
        int team1Goal = randomGoals();
        int team2Goal = randomGoals();
        if (!flag) {
            team1Goal = userTeamGoal(team1, team2);
            if (team1Goal == -1) return false;
            team2Goal = userTeamGoal(team2, team1);
            if (team2Goal == -1) return false;
        }
        adjustPoints(currPair, team1Goal, team2Goal, true);
        String message = team1.getTeamName() + " goals : " + team1Goal + "\n" + team2.getTeamName() + " goals : " + team2Goal;
        if (team1Goal > team2Goal) message += "\n" + team1.getTeamName() + " wins!!";
        else if (team1Goal < team2Goal) message += "\n" + team2.getTeamName() + " wins!!";
        else message += "\nA draw!!";
        JOptionPane.showMessageDialog(null, message, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static void revertAMatch(Fixture fixture, int currentMatch, int currentWeek) {
        int team1Goal = fixture.getWeekList().get(currentWeek).getPairs().get(currentMatch).getTeam1Goals();
        int team2Goal = fixture.getWeekList().get(currentWeek).getPairs().get(currentMatch).getTeam2Goals();
        Pair currPair = fixture.getWeekList().get(currentWeek).getPairs().get(currentMatch);
        adjustPoints(currPair, team1Goal, team2Goal, false);
    }
    
    public static void saveFixture(List<Fixture> fixture, String path) {
        try (FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(fixture);
        } catch (IOException e) {
            System.out.println("Fixture write error!");
        }
    }

    public static List<Fixture> loadFixture(String path) {
        List<Fixture> fixture = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            fixture = (List<Fixture>) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fixture read error!");
        }
        return fixture;
    }
}
