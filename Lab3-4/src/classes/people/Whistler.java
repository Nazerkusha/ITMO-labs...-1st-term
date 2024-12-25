package classes.people;
import classes.places.Placelocation;
public class Whistler extends Character {
    public Whistler(String name, Placelocation place) {
        super(name, place);
    }
    @Override
    public String toString() {
        return getName();
    }

}
