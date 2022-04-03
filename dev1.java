package Layer1_Dev;

import java.rmi.RemoteException;

public class dev1 {
                  /**Start button**/
    public static boolean ispressed() {

    return  Button.isPressed();

    }
                /**Check the color in input**/
    public static void idcolor() {
     DropSensor.isProductReady();
    }
    public static boolean readcolor() {
        return DropSensor.isProductReady();

    }
                  /********** ConveyorMotor 1 *********/
    public static void startconvoyor1(){

            ConveyorMotor.runconveyor1(450);
    }

    public static void stopconvoyor1() {
        ConveyorMotor.Stopconveyor1();
    } public static void stopconvoyor1Umergency() {
        ConveyorMotor.runconveyor1(0);
    }



                        /********** Shredder Motor ***********/

    public static void startshrederMotor() {
        ShredderMotor.runShredermotorstart(700);
          }
    public static void re_startshrederMotor() {
        ShredderMotor.re_runShredermotor(500);
    }
    public static void stoptshrederUmergency() {
        ShredderMotor.runShredermotorstart(0);
    }
    public static void stoptshrederMotor() {
        ShredderMotor.stopShredder();
    }
                  /****************** Ultrasonic Sensor ****************/
    public static int ultrasonicSensor() {

      //  UltrasonicSensor.isDanger();
        return UltrasonicSensor.isDanger();
    }
                      /** Check color of product**/

        public static int CheckColor() {
                          if (ColorSensor.waitBrick()) {
                              return ColorSensor.decideColor();
                          }
                          else if (!ColorSensor.waitBrick()) {
                              ColorSensor.waitBrick();
                          }
                          return CheckColor();
        }
      public static int NoBrick() {
                          if (!ColorSensor.waitBrick()) {
                              return ColorSensor.decideColor();
                          }
                          else if (ColorSensor.waitBrick()) {
                              ColorSensor.waitBrick();
                          }

                  return NoBrick();
        }
                  /**************** Drop Motor ***************/
    public static void dropmotorReset() {

        DropMotor.resetPosition(40,0);

          }
          public static void  dropMotor() {
             DropMotor.dropup();
          }
        public static void dropdown() {
            DropMotor.dropdown();

        }

                   /********* Conveyor motor 2************/
    public static void FirstStartconvoyor2() {
        ConveyorMotor2.GoBluePosition(800);
    }

    public static void SecondStartconvoyor2() {
        ConveyorMotor2.GoGreenPosition(800);
    }

    public static void ThirdStartconvoyor2() {
        ConveyorMotor2.GoYelloPosition(800);
    }
    public static void FourthStartconvoyor2() {
        ConveyorMotor2.GoRedPosition(950);
    }

}


























/*



    public static void motorA(){
    m.runMotor(500);

    }



    public static void init1(){
        if (true){

        }

    }
    public static void confs1(final EV3ColorSensor color){

    }
    public void config() {
        final EV3ColorSensor color = new EV3ColorSensor(SensorPort.S1);
        System.out.println("Color detect");
        color.getRGBMode();
        int number =color.getColorID();
        if (number== Color.RED){
            System.out.println("Red Detected");
            m.runMotor(400);
        }
        else if (number==Color.BLUE) {
            System.out.println("Blue Detected");
            m.runMotor(800);

        }
        else if (number==Color.YELLOW) {
            System.out.println("Yellow Detected");
            m.runMotor(1000);

        }
        else if (number==Color.GREEN) {
            System.out.println("Green Detected");
        }
        else {
            System.out.println("No Color");
            m.Stop();
        }
    }
}
*/