package classes.places;

import enums.location;
import classes.people.Character;

public class Newspaperoffice extends Placelocation {
    public Newspaperoffice(String name) {
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
