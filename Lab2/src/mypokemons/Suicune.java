package mypokemons;

import myattaks.SpecialMove.*;
import myattaks.StatusMove.*;
import ru.ifmo.se.pokemon.*;
public class Suicune extends Pokemon {
    public Suicune(java.lang.String name, int level){
        super(name,level);
        super.setStats(100, 75, 115, 90, 115, 85);
        super.setType(Type.WATER);


        Leer leer = new Leer(0, 100);
        BubbleBeam bubblebeam = new BubbleBeam(65, 100);
        Confide confide = new Confide(0, 0);
        DoubleTeam doubleteam = new DoubleTeam(0, 0);

        super.setMove(leer, doubleteam, confide, bubblebeam);

    }
}