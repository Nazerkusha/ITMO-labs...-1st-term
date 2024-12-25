package classes.people;
import classes.places.Placelocation;
import records.WhistlerMissing;
import java.util.Objects;

public abstract class Character {
        protected String name;
        protected Placelocation whereIsPerson;

        public Character(String name, Placelocation whereIsPerson) {

            this.name = name;
            this.whereIsPerson = whereIsPerson;
        }

        public void moveToRoom(Placelocation placelocation) {
            if (this.whereIsPerson != null) {
                this.whereIsPerson.exit(this);
            }
            this.whereIsPerson = placelocation;
            placelocation.enter(this);
        }
        public String getName() {
            return name;
        }
        public String getLoc() {
            return String.valueOf(whereIsPerson);
        }
        public Placelocation getpl() {
            return whereIsPerson;
        }
    public int know(String name, Character character, int missing) {
        WhistlerMissing Wm = new WhistlerMissing(name, character);
        if (Math.random() <= 0.1 | missing == 1) {
            System.out.println(character.toString() + " знает где находится " + name);
            missing = 0;
            return missing;
        } else {
            System.out.println(Wm.toString());

        }
        return missing;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character character = (Character) obj;
        return Objects.equals(name, character.name) && Objects.equals(whereIsPerson, character.whereIsPerson);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, whereIsPerson);
    }

}
