package interfaces;

import classes.people.Character;
import classes.places.Placelocation;

public interface TalkableLookable {
    void say(Character character);
    void look(Placelocation place);
}
