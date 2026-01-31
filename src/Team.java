public class Team {
    private String name;
    private Player[] players; // changed
    private int rankingPoints;
    private String strategy;

    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
        this.rankingPoints = 0;
        this.strategy = "";
    }

    public String getName() { return name; }
    public Player[] getPlayers() { return players; }

    public int getRankingPoints() { return rankingPoints; }
    public void addRankingPoints(int points) { rankingPoints += points; }

    public String getStrategy() { return strategy; }
    public void setStrategy(String strategy) { this.strategy = strategy; }
}



