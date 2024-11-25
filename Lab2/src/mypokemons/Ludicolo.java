package mypokemons;

import myattaks.SpecialMove.*;
import myattaks.StatusMove.*;
import ru.ifmo.se.pokemon.*;
public class Ludicolo extends Pokemon {
    public Ludicolo(java.lang.String name, int level) {
        super(name, level);
        super.setStats(80, 70, 70, 90, 100, 70);
        super.setType(Type.WATER, Type.GRASS);

        Confide confide = new Confide(0, 0);
        Rest rest = new Rest(0,0);
        Absorb absorb = new Absorb(20,100);
        FocusBlast focusblast = new FocusBlast(120,70);
        super.setMove(confide, rest, absorb, focusblast);

    }
}