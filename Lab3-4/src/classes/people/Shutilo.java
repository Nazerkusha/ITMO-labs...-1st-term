package classes.people;
import classes.places.Placelocation;

public class Shutilo extends Character {
    public Shutilo(String name, Placelocation place) {
        super(name, place);
    }

    @Override
    public String toString() {
        return getName();
    }
}