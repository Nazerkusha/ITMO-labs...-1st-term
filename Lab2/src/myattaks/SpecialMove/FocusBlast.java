package myattaks.SpecialMove;

import ru.ifmo.se.pokemon.*;

public class FocusBlast extends SpecialMove {
    public FocusBlast(double pow, double acc) {
        super(Type.FIGHTING, pow, acc);
    }

    private boolean flag;

    @Override
    protected String describe() {
        if (flag) {
            return "uses Focus Blast and reduces the enemy's Special Defense by 1 stage";
        } else {
            return "uses Focus Blast";
        }
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1) {
            flag = true;
            Effect effect = new Effect();
            effect.stat(Stat.SPECIAL_DEFENSE, -1);
            p.addEffect(effect);
        }
    }
}