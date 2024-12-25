package classes.people;
import classes.places.Placelocation;
import exeptions.InvalidNotWhistlerInHospital;
import interfaces.Reportable;
import interfaces.Thinkable;

public class Compress extends Character implements Reportable, Thinkable {
    private Placelocation job;

    public Compress(String name, Placelocation place) {
        super(name, place);
        job = getpl();
    }

    public void call(Placelocation a, Character character) {
            try {
                if (job.getPeoples().contains(character))
                    System.out.println(getName() + " позвонил в " + a.receiveName());
                else
                    throw new InvalidNotWhistlerInHospital(this) {
                    };
            }
            catch (InvalidNotWhistlerInHospital e){
                System.out.println(e.getMessage() + a.receiveName());
            }
        }

    @Override
    public void think() {
        System.out.println(getName() + " подумал немного");
    }
    @Override
    public String toString() {
        return getName();
    }
}

