package sim2.esprit.raid.roulette;

/**
 * Created by Raid on 1/20/17.
 */

public class DesignedNumber {

int number;
    int angle;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public DesignedNumber(int number, int angle) {
        this.number = number;
        this.angle = angle;
    }

    public DesignedNumber() {
    }


}
