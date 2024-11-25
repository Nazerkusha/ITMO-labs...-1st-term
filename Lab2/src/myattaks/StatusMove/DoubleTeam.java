package myattaks.StatusMove;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    @Override
    protected String describe() {
        return "uses Double Team, increases Evasion by 1 stage";
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true;
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect effect = new Effect();
        effect.stat(Stat.EVASION, +1);
        p.addEffect(effect);

    }
}