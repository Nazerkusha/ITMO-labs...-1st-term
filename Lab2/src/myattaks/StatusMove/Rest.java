package myattaks.StatusMove;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest(double pow, double acc) {
        super(Type.PSYCHIC, pow, acc);
    }

    @Override
    protected String describe() {
        return "falls asleep for 2 turns and restores all his health";
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true;
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.restore();
        Effect effect = new Effect();
        effect = effect.condition(Status.SLEEP).turns(2);
        p.addEffect(effect);
    }
}