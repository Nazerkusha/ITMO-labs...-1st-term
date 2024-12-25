package interfaces;

import classes.people.Character;
import classes.places.Placelocation;

public interface Reportable {
    void call(Placelocation pla, Character person);
}
