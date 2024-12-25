package classes.people;
import classes.places.Placelocation;

public class Karaulkin extends Character {
    public Karaulkin(String name, Placelocation place) {
        super(name, place);
    }
    @Override
    public String toString() {
        return getName();
    }
}
