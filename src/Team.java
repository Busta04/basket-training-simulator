public class Team {
    private String name;
    private String[] players; // 5 players
    private int rankingPoints;
    private String strategy;

    public Team(String name, String[] players) {
        this.name = name;
        this.players = players;
        this.rankingPoints = 0;
        this.strategy = "";
    }

    // Getters and setters
    public String getName() { return name; }
    public String[] getPlayers() { return players; }

    public int getRankingPoints() { return rankingPoints; }
    public void addRankingPoints(int points) { rankingPoints += points; }

    public String getStrategy() { return strategy; }
    public void setStrategy(String strategy) { this.strategy = strategy; }
}


