package myattaks.SpecialMove;

import ru.ifmo.se.pokemon.*;

public class BubbleBeam extends SpecialMove {
    public BubbleBeam(double pow, double acc) {
        super(Type.WATER, pow, acc);
    }

    @Override
    protected String describe() {
        if (flag) {
            return "uses Bubble Beam and reduces Speed by 1 stage";
        } else {
            return "uses Bubble Beam";
        }
    }

    private boolean flag;

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect effect = new Effect();
        if (Math.random() <= 0.1) {
            flag = true;
            effect.stat(Stat.SPEED, -1);
        }
    }
}