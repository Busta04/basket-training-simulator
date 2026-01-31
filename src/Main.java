import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Action> actionsList = new ArrayList<>();
        List<String> playerNames = new ArrayList<>();

        // --- Read actions from file ---
        try (Scanner scanner = new Scanner(new File("actions.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    // Expecting format: Name,Points
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        int points = Integer.parseInt(parts[1].trim());
                        actionsList.add(new Action(name, points));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("actions.txt not found!");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing points in actions.txt!");
            return;
        }

        // --- Read player names from file ---
        try (Scanner scanner = new Scanner(new File("players.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    playerNames.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("players.txt not found!");
            return;
        }

        // --- Ask user for team names ---
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name for Team 1: ");
        String team1Name = input.nextLine().trim();
        System.out.print("Enter name for Team 2: ");
        String team2Name = input.nextLine().trim();

        // --- Assign 5 random players per team ---
        if (playerNames.size() < 10) {
            System.out.println("Not enough player names in players.txt (need at least 10).");
            return;
        }

        Collections.shuffle(playerNames);

        List<Player> team1Players = new ArrayList<>();
        List<Player> team2Players = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            team1Players.add(new Player(playerNames.get(i)));
            team2Players.add(new Player(playerNames.get(i + 5)));
        }

        Team team1 = new Team(team1Name, team1Players.toArray(new Player[0]));
        Team team2 = new Team(team2Name, team2Players.toArray(new Player[0]));

        System.out.println("\nTeams created:");
        System.out.println(team1.getName() + ": " + Arrays.toString(team1.getPlayers()));
        System.out.println(team2.getName() + ": " + Arrays.toString(team2.getPlayers()));

        System.out.println("\nAvailable actions:");
        for (Action a : actionsList) {
            System.out.println("- " + a);
        }

        // --- Start the match ---
        Match match = new Match(team1, team2, actionsList);
        match.start();

        // --- Display final ranking points ---
        System.out.println("\nUpdated ranking points:");
        System.out.println(team1.getName() + ": " + team1.getRankingPoints());
        System.out.println(team2.getName() + ": " + team2.getRankingPoints());
    }
}
