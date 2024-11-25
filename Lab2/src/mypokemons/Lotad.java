package mypokemons;

import myattaks.StatusMove.*;
import ru.ifmo.se.pokemon.*;
public class Lotad extends Pokemon {
    public Lotad(java.lang.String name, int level) {
        super(name, level);
        super.setStats(40, 30, 30, 40, 50, 30);
        super.setType(Type.WATER, Type.GRASS);

        Confide confide = new Confide(0, 0);
        Rest rest = new Rest(0,0);
        super.setMove(confide, rest);
    }
}
