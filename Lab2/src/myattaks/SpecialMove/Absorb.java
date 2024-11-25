package myattaks.SpecialMove;

import ru.ifmo.se.pokemon.*;

public class Absorb extends SpecialMove {
    public Absorb(double pow, double acc) {
        super(Type.GRASS, pow, acc);
    }

    @Override
    protected String describe() {
        return "uses Absorb and restores 50% HP from the attack";
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
        Effect effect = new Effect();
        effect.stat(Stat.HP, -(((int) Math.round(damage)) / 2));
    }
}