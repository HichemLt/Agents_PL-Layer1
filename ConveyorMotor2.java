package Layer1_Dev;

import lejos.utility.Delay;

public class ConveyorMotor2 {

    public static void GoGreenPosition(int speed) {
        InitComp.motor2.setSpeed(speed);
        Delay.msDelay(1);
        InitComp.motor2.backward();
        Delay.msDelay(1050);
        InitComp.motor2.stop();
        InitComp.motor2.getPosition();
    }
    public static void GoBluePosition(int speed) {
        InitComp.motor2.setSpeed(speed);
        Delay.msDelay(1);
        InitComp.motor2.backward();
        Delay.msDelay(800);
        InitComp.motor2.stop();
        InitComp.motor2.getPosition();
    }
    public static void GoYelloPosition( int speed){
        InitComp.motor2.setSpeed(speed);
        Delay.msDelay(1);
        InitComp.motor2.backward();
        Delay.msDelay(1380);
        InitComp.motor2.stop();
        InitComp.motor2.getPosition();
    }
    public static void GoRedPosition(int speed) {
        InitComp.motor2.setSpeed(speed);
        Delay.msDelay(1);
        InitComp.motor2.backward();
        Delay.msDelay(2500);
        InitComp.motor2.stop();
        InitComp.motor2.getPosition();
    }
    public static void runconvoyer(int speed) {
        InitComp.motor2.setSpeed(speed);
        Delay.msDelay(1);
        InitComp.motor2.rotateTo(-500);
    }
    //////////////
    /*
    public static void start(int motorSpeed){
        motor1.setSpeed(100);

        System.out.println("Convoyer Started");
    }
    public static void startSlaow(int motorSpeed){
        motor1.setSpeed(20);

        System.out.println("Convoyer Slow Started");
    }
        public static void Stop() {
        motor1.stop();
    }



    public static void runDegs(int angle, int speed){
          motor1.setSpeed(speed);
   //     Delay.msDelay(500);
          motor1.rotate(angle);
         // motor1.rotateTo();
*/
    }
    //---------------
    /* def brickStucked(self):
            dev1.psm.BBM2.runSecs(2, -100, True)
            print(f'Brick stucked')


        def runDegs(self,degree,speed):
            dev1.psm.BBM2.runDegs(degree, speed, True, False)
            motorState = dev1.psm.BBM2.isBusy()
            print(f'Motor rotated {degree} degree on {speed} speed')
            return motorState # returns true when motor busy

     */

