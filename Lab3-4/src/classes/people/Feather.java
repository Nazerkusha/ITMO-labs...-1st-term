package classes.people;
import classes.places.Placelocation;
import interfaces.Askable;
import interfaces.TalkableLookable;

public class Feather extends Character implements Askable, TalkableLookable {
    public Feather(String name, Placelocation place) {
        super(name, place);

    }
    @Override
    public void ask(Character character) {
        System.out.println(getName() + " допрашивает " + character.getName());
    }
    @Override
    public void look(Placelocation place) {
        System.out.println(getName() + " рассматривает разрушения в  " + place.receiveName());
    }
    @Override
    public void say(Character character){
        System.out.println(getName() + " говорит " + character.getName() + " что ");
    }
    @Override
    public void findOut(Character character){
        System.out.println(getName() + " узнаёт от " + character.getName() + " что Свистулькин не пропал");
    }
    public void findOut(Character character, Character character2){
        System.out.println(getName() + " узнаёт от " + character.getName() + " и " + character2.getName() + " что Свистулькин не пропал");
    }
    @Override
    public String toString() {
        return getName();
    }
}
