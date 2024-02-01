/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fikstur;

//import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author mtpc
 */
public class Main {
    public static void main(String args[]) {
        
        //Scanner scan = new Scanner(System.in);
        
        int tCount = 5;
        List<Team> teamList = new ArrayList<>();
        for(int i = 0; i < tCount; ++i) {
            Team newTeam = new Team("team" + i);
            teamList.add(newTeam);
        }
        
        Fixture fix = new Fixture("Deneme", tCount, teamList);
        //selectFixture.fixtures.add(fix);
        //Functions.saveFixture(selectFixture.fixtures, "fixtures.ser");
        //System.out.println(Functions.randomGoals());

        //selectFixture frame = new selectFixture();
        //frame.fixtures.add(fix);
        //frame.setVisible(true);
    }
}
