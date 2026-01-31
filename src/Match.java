import java.util.*;

public class Match {
    private Team team1;
    private Team team2;
    private List<Action> actions;

    private int team1Score;
    private int team2Score;
    private Random random = new Random();

    public Match(Team t1, Team t2, List<Action> actions) {
        this.team1 = t1;
        this.team2 = t2;
        this.actions = actions;
        this.team1Score = 0;
        this.team2Score = 0;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ready to start the match: " + team1.getName() + " vs " + team2.getName() + "? (yes/no)");
        String response = input.nextLine().trim().toLowerCase();
        if (!response.equals("yes")) {
            System.out.println("Match cancelled.");
            return;
        }

        int totalMinutes = 48;
        int virtualMinute = 0;
        int actionInterval = 2 + random.nextInt(2); // 2-3 minutes per action

        while (virtualMinute < totalMinutes) {
            virtualMinute++;
            // Random points scored automatically
            if (random.nextDouble() < 0.1) { // approx frequency of scoring
                int points = random.nextBoolean() ? 2 : 3;
                if (random.nextBoolean()) {
                    team1Score += points;
                    System.out.println(team1.getName() + " scores " + points + " points! (auto)");
                } else {
                    team2Score += points;
                    System.out.println(team2.getName() + " scores " + points + " points! (auto)");
                }
            }

            // Check for action opportunity
            if (virtualMinute % actionInterval == 0) {
                Action action = actions.get(random.nextInt(actions.size()));
                System.out.println("\n--- Action opportunity! ---");
                System.out.println("Action: " + action.getName() + " (" + action.getPoints() + " pts)");
                System.out.println("Perform this action in real life! Did you succeed? (yes/no)");
                String success = input.nextLine().trim().toLowerCase();
                if (success.equals("yes")) {
                    // Randomly assign to one team
                    if (random.nextBoolean()) {
                        team1Score += action.getPoints();
                        System.out.println(team1.getName() + " gets " + action.getPoints() + " pts!");
                    } else {
                        team2Score += action.getPoints();
                        System.out.println(team2.getName() + " gets " + action.getPoints() + " pts!");
                    }
                } else {
                    System.out.println("No points awarded for this action.");
                }
                // Reset next action interval
                actionInterval = virtualMinute + 2 + random.nextInt(2);
            }

            // Simulate virtual time speed (optional)
            try {
                Thread.sleep(250); // speed up x4, can adjust
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n--- MATCH ENDS ---");
        System.out.println(team1.getName() + ": " + team1Score + " pts");
        System.out.println(team2.getName() + ": " + team2Score + " pts");

        if (team1Score > team2Score) {
            System.out.println(team1.getName() + " wins!");
        } else if (team2Score > team1Score) {
            System.out.println(team2.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }

        // Update ranking points
        team1.addRankingPoints(team1Score);
        team2.addRankingPoints(team2Score);
    }
}


