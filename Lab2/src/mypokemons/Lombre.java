package mypokemons;

import myattaks.SpecialMove.*;
import myattaks.StatusMove.*;
import ru.ifmo.se.pokemon.*;
public class Lombre extends Pokemon {
    public Lombre(java.lang.String name, int level) {
        super(name, level);
        super.setStats(60, 50, 50, 60, 70, 50);
        super.setType(Type.WATER, Type.GRASS);

        Confide confide = new Confide(0, 0);
        Rest rest = new Rest(0,0);
        Absorb absorb = new Absorb(20,100);
        super.setMove(confide, rest, absorb);


    }
}