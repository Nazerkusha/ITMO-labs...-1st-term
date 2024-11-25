package myattaks.SpecialMove;

import ru.ifmo.se.pokemon.*;

public class FlashCannon extends SpecialMove {
    public FlashCannon(double pow, double acc) {
        super(Type.STEEL, pow, acc);
    }
    private boolean flag;

    @Override
    protected String describe() {
        if (flag) {
            return "uses Canon Flash, and reduces the enemy's Self Defense by 1 stage";
        } else {
            return "uses Canon Flash";
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