package mypokemons;

import myattaks.SpecialMove.*;
import myattaks.StatusMove.Swagger;
import ru.ifmo.se.pokemon.*;
public class Starmie extends Pokemon {
    public Starmie(java.lang.String name, int level) {
        super(name, level);
        super.setStats(60, 75, 85, 100, 85, 115);
        super.setType(Type.WATER, Type.PSYCHIC);

        Psychic psychic = new Psychic(90, 100);
        FlashCannon flashcannon = new FlashCannon(80, 100);
        Swagger swagger = new Swagger(0, 85);
        DreamEater dreameater = new DreamEater(100, 100);
        super.setMove(psychic, flashcannon, swagger, dreameater);


    }
}