package mypokemons;

import myattaks.SpecialMove.*;
import myattaks.StatusMove.Swagger;
import ru.ifmo.se.pokemon.*;

public class Staryu extends Pokemon {
    public Staryu(java.lang.String name, int level) {
        super(name, level);
        super.setStats(30, 45, 55, 70, 55, 85);
        super.setType(Type.WATER);

        Psychic psychic = new Psychic(90, 100);
        FlashCannon flashcannon = new FlashCannon(80, 100);
        Swagger swagger = new Swagger(0, 85);
        super.setMove(psychic, flashcannon, swagger);
    }
}