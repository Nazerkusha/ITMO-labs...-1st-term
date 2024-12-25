package classes.places;

import classes.people.Character;
import enums.location;


public class Policestation extends Placelocation {
    public Policestation(String name) {
        super(name);
    }
    @Override
    protected String changeLocation(Character character, location Location) {
        switch (Location) {
            case ENTER:
                return character.getName() + " заходит в " + receiveName();
            case EXIT:
                return character.getName() + " уходт из " + receiveName();
            default:
                return "";
        }
    }
    @Override
    public String toString() {
        return receiveName();
    }
}
