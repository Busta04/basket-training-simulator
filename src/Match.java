public class Match {
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = 0;
        this.team2Score = 0;
    }

    // Methods to add points
    public void addPointsTeam1(int points) { team1Score += points; }
    public void addPointsTeam2(int points) { team2Score += points; }

    // Get current match points
    public int getTeam1Score() { return team1Score; }
    public int getTeam2Score() { return team2Score; }

    // Finish the match and update ranking points
    public void finishMatch() {
        team1.addRankingPoints(team1Score);
        team2.addRankingPoints(team2Score);
    }
}

