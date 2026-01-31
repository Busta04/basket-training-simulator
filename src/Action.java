public class Action {
    private String name;
    private int points;

    public Action(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() { return name; }
    public int getPoints() { return points; }

    @Override
    public String toString() {
        return name + " (" + points + " pts)";
    }
}


