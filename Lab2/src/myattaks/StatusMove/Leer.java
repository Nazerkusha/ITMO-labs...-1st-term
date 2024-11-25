package myattaks.StatusMove;

import ru.ifmo.se.pokemon.*;

public class Leer extends StatusMove {
    public Leer(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected String describe() {
        return "uses Leer, reduces Defense by 1 stage to the enemy";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect effect = new Effect();
        effect.stat(Stat.DEFENSE, -1);
        p.addEffect(effect);
    }
}
