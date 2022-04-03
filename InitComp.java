package Layer1_Dev;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import ev3dev.sensors.ev3.EV3ColorSensor;
import ev3dev.sensors.ev3.EV3TouchSensor;
import ev3dev.sensors.ev3.EV3UltrasonicSensor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class InitComp {
    //      static EV3LargeRegulatedMotor shredermotor = new EV3LargeRegulatedMotor(MotorPort.C);

        public static EV3LargeRegulatedMotor motor1 = null;
        public static EV3LargeRegulatedMotor motor2 = null;
        static EV3MediumRegulatedMotor motor3 = null;
        static EV3LargeRegulatedMotor shredermotor = null;
        static EV3MediumRegulatedMotor dropmotor = null;
        static EV3TouchSensor touchSensor = null;
       public static EV3ColorSensor Colorsensor = null;
        static EV3UltrasonicSensor ultrasonicSensor = null;

        static EV3ColorSensor color = null;


        public static void initComponents(){
            Colorsensor= new EV3ColorSensor(SensorPort.S1);
            touchSensor= new EV3TouchSensor(SensorPort.S2);
            ultrasonicSensor= new EV3UltrasonicSensor(SensorPort.S3);
            color= new EV3ColorSensor(SensorPort.S4);
            dropmotor = new EV3MediumRegulatedMotor(MotorPort.A);
            motor1 = new EV3LargeRegulatedMotor(MotorPort.B);
            shredermotor= new EV3LargeRegulatedMotor(MotorPort.C);
            motor2 = new EV3LargeRegulatedMotor(MotorPort.D);
        }


    }
