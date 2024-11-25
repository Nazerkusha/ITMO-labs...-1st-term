package myattaks.StatusMove;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide(double pow, double acc) {
        super(Type.NORMAL, pow, acc);

    }

    @Override
    protected String describe() {
        return "uses Confide, and reduces the opponent's Special Attack by 1 stage";
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true;
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect effect = new Effect();
        effect.stat(Stat.SPECIAL_ATTACK, -1);
        p.addEffect(effect);
    }
}