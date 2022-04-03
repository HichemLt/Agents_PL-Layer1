package Layer1_Dev;

import lejos.utility.Delay;

public class DropMotor {

    public static void resetPosition(int speed ,int degre) {
        InitComp.dropmotor.setSpeed(speed);
        Delay.msDelay(1);
        InitComp.dropmotor.rotateTo(degre);    }
    public static void dropup(){
        InitComp.dropmotor.setSpeed(800);
        Delay.msDelay(1);
        InitComp.dropmotor.rotateTo(180);
        Delay.msDelay(10);
        InitComp.dropmotor.rotateTo(0);
    }
    public static void dropdown()  {
        InitComp.dropmotor.rotateTo(0);

    }

}
