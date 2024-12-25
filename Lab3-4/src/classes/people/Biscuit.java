package classes.people;
import classes.places.Placelocation;


public class Biscuit extends Character{
    public Biscuit(String name, Placelocation place) {
        super(name, place);
    }

    @Override
    public String toString() {
        return getName();
    }

}
