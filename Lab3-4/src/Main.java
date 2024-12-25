import classes.places.*;
import classes.people.*;

public class Main {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("Больница");
        Newspaperoffice newspaperoffice = new Newspaperoffice("Газетный оффис");
        Policestation policestation = new Policestation("Полицейский участок");
        Somwhereelse somewhere = new Somwhereelse("Другое место");
        Compress drCompress = new Compress("Компрессик", hospital);
        Shutilo shutilo = new Shutilo("Шутило", hospital);
        Biscuit biscuit = new Biscuit("Коржик", hospital);
        Feather feather = new Feather("Пёрышкин", newspaperoffice);
        Whistler policeWistler = new Whistler("Свистулькин", somewhere);
        if (Math.random() <= 0.5) {
            policeWistler.moveToRoom(hospital);
        }
        Poppy babyPoppy = new Poppy("Маковка", somewhere);
        Karaulkin policeKaraulkin = new Karaulkin("Караулькин", policestation);
        System.out.println("Start");
        shutilo.moveToRoom(somewhere);
        biscuit.moveToRoom(somewhere);
        drCompress.think();
        String Whistlerloc = policeWistler.getLoc();
        int missing = 1;
        int a = 0;

        if (Whistlerloc == String.valueOf(hospital)) {
            drCompress.call(newspaperoffice, policeWistler);
            missing = 0;
            feather.findOut(drCompress);
        } else {
            drCompress.call(newspaperoffice, policeWistler);
            a = missing;
        }
        feather.moveToRoom(hospital);
        if (missing == 1){
            feather.ask(drCompress);
        }
        else {
            feather.ask(drCompress);
            feather.ask(policeWistler);
        }
        feather.moveToRoom(shutilo.getpl());
        feather.ask(shutilo);
        feather.ask(biscuit);
        missing = biscuit.know(String.valueOf(policeWistler), biscuit, missing);
        missing  = shutilo.know(String.valueOf(policeWistler), shutilo, missing);
        if (missing == 0 & a == 1) {
            feather.findOut(shutilo, biscuit);
            a = 0;
        }
        feather.moveToRoom(babyPoppy.getpl());
        feather.ask(babyPoppy);
        missing = babyPoppy.know(String.valueOf(policeWistler), babyPoppy, missing);
        if (missing == 0 & a == 1) {
            feather.findOut(babyPoppy);
        }
        feather.moveToRoom(policestation);
        feather.look(policestation);
        if (missing == 1) {
            feather.say(policeKaraulkin);
            System.out.println(policeWistler+ " Всё ещё пропавший");
        }
        else {
            feather.say(policeKaraulkin);
            System.out.println(policeWistler+ " нашёлся");
        }


    }


}
