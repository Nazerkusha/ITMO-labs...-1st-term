package records;

import classes.people.Character;

public record WhistlerMissing(String name, Character character) {
    @Override
    public String toString() {
        return character.toString() + " незнает где находится " + name;
    }
}

