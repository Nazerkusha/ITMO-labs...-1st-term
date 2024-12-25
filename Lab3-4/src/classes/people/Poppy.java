package classes.people;
import classes.places.Placelocation;

public class Poppy extends Character {
    public Poppy(String name, Placelocation place) {
        super(name, place);
    }

    @Override
    public String toString() {
        return getName();
    }
}
