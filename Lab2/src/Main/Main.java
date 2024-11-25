package Main;
import mypokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Starmie starmie = new Starmie("pokemon", 1);
        Ludicolo ludicolo = new Ludicolo("pokemon", 1);
        Lombre lombre = new Lombre("pokemon", 1);
        Lotad lotad = new Lotad("pokemon", 1);
        Staryu staryu = new Staryu("pokemon", 1);
        Suicune suicune = new Suicune("pokemon", 1);
        b.addAlly(starmie);
        b.addAlly(ludicolo);
        b.addAlly(lombre);
        b.addFoe(suicune);
        b.addFoe(staryu);
        b.addFoe(lotad);
        b.go();
    }
}
//310895