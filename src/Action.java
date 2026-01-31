public class Action {
    private String name;
    private String position; 

    Action(String name, String position){
        this.name=name;
        this.position=position;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }
}
