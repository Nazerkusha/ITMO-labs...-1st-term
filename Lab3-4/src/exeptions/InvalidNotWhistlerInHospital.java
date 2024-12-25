package exeptions;
import classes.people.Character;


public class InvalidNotWhistlerInHospital extends Exception{
    Character human;
    public InvalidNotWhistlerInHospital(Character person) {
        this.human = person;
    }
    @Override
    public String getMessage() {
        return String.format("Свистулькина нет в больнице, но " + human.getName() + " всё равно звонит в ");
    }
}

