package myattaks.StatusMove;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected String describe() {
        return "uses Swagger, increases the enemy's attack by 2 stages and uses confusion on him";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect effect = new Effect();
        effect.stat(Stat.ATTACK, +2);
        p.addEffect(effect);
        p.confuse();
    }
}