package classes.places;
import enums.location;
import java.util.ArrayList;
import classes.people.Character;
public abstract class Placelocation {
    protected String name;
    protected ArrayList<Character> peoples;
    public Placelocation(String name) {
        this.name = name;
        this.peoples = new ArrayList<>();
    }
    protected abstract String changeLocation(Character character, location Location);
    public void enter(Character character)  {
        if(!peoples.contains(character)) {
            peoples.add(character);
        }
        String action = changeLocation(character, location.ENTER);
        System.out.println(action);
    }
    public void exit(Character character) {
        if(peoples.contains(character)) {
            peoples.remove(character);
        }
        String action = changeLocation(character, location.EXIT);
        System.out.println(action);
    }
    public String receiveName() {
        return name;
    }

    public ArrayList<Character> getPeoples() {
        return peoples;
    }

    public Character showCharactersInPlace() {
        if(!peoples.isEmpty()) {
            System.out.println("В " + receiveName() + " находятся ");
            for(Character character: peoples) {
                return character;
            }
        } else {
            System.out.println("В " + receiveName() + " никого нет");
            return null;
        }
        return null;
    }
    @Override
    public String toString() {
        return "Комната: " + receiveName() + ", количество персонажей: " + peoples.size();
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

