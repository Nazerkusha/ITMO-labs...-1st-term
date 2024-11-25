package myattaks.SpecialMove;

import ru.ifmo.se.pokemon.*;

public class DreamEater extends SpecialMove {
    public DreamEater(double pow, double acc) {

        super(Type.PSYCHIC, pow, acc);
    }

    @Override
    protected String describe() {
        if (flag) {
            return "uses Dream Eater on a sleeping opponent, and restores 50% HP from the damage inflicted";
        } else {
            return "does nothing";
        }
    }

    private boolean flag;

    @Override
    protected void applyOppDamage(Pokemon def, double attack) {
        Status stat = def.getCondition();
        if (stat.equals(Status.SLEEP)) {
            flag = true;
            def.setMod(Stat.HP, (int) Math.round(attack));
        }
    }

    @Override
    protected void applySelfDamage(Pokemon att, double attack) {
        if (flag) {
            att.setMod(Stat.HP, -(((int) Math.round(attack)) / 2));
        }
    }
}