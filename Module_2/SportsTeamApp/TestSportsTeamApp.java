/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_2.SportsTeamApp;

import java.util.Scanner;

public class TestSportsTeamApp {
        public static void main(String[] args) {
        System.out.println("  Welcome to the Sports Team App");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" ");
            System.out.print("  Enter a team name: ");
            String teamName = scanner.nextLine();

            Team team = new Team(teamName);

            System.out.println(" ");
            System.out.println("  Enter the player name:");
            System.out.print("    hint: use commas for multiple players; no spaces>: ");
            String playerNames = scanner.nextLine();

            String[] players = playerNames.split(",");
            for (String player : players) {
                team.addPlayer(player.trim());
            }

            System.out.println(" ");
            System.out.println("  --Team Summary--");
            System.out.println("  Number of players in team: " + team.getPlayerCount());
            System.out.println("  Players on team: " + String.join(",", team.getPlayers()));

            System.out.println(" ");
            System.out.print("  Continue? (y/n) ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("End of line... ");
                break;
            }
                        
        }

        scanner.close();
    }
}