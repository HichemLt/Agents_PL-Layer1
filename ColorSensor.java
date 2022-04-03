package Layer1_Dev;


public class ColorSensor {
    // static final EV3ColorSensor color = new EV3ColorSensor(SensorPort.S4);
//            readedcolorlist = [0]*10
    static boolean call_mode = false;

    public static float x = 0;
/*    public static void waitBrick() {

        if (!call_mode) {
            InitComp.color.getRGBMode();
          //  InitComp2.colorSensor.getRGBMode();
            call_mode = true;
        }
        int readcolrlist[] = new int[0 * 10];
       // int idcolor = InitComp.color.getColorID();
        int idcolor = InitComp.color.getColorID();

        int index = 0;
        boolean sensorOku = true;
        while (sensorOku) {
            readcolrlist[index] = idcolor;
            LocalTime now = LocalTime.now();
            DateTimeFormatter cr_time = DateTimeFormatter.ofPattern("HH:mm:ss");
            index = index + 1;
            int sum = IntStream.of(readcolrlist[index]).sum();
            int x = (sum) / 10;
            if (index == 10) {
                if (x == 3 || x == 4 || x == 5 || x == 6) {
                    System.out.printf(String.valueOf(index), cr_time, idcolor);
                    System.out.println("Retval : " + x);
                    //  dev1.retVal = x

                } else {
                    // dev1.retVal = 0.0
                }
            }
        }
    }*/

    public static void readcolor() {
        if (!call_mode) {
            InitComp.Colorsensor.getRGBMode();

            call_mode = true;
        }
        //  System.out.println("Color readed" + InitComp.color.getColorID());
    }

    public static int decideColor() {
        if (!call_mode) {
            InitComp.Colorsensor.getRGBMode();

            call_mode = true;
        }
        //int[] colorSamplings = new int[10];
        float colorSamplings = 0;
        //   System.out.println("Reading is starting");
        int index = 0;
        while (index < 19) {
            int idcolor = InitComp.color.getColorID();
            //System.out.println("clrID" + idcolor);
            colorSamplings += idcolor;
            index = index + 1;
        }
        x = (colorSamplings) / 20; // take the average.
        //  System.out.println("Id color = "+Math.round(x));
        //return Math.round(x);
        return Math.round(x);
    }

    public static boolean waitBrick() {
        if (!call_mode) {
            InitComp.Colorsensor.getRGBMode();

            call_mode = true;
        }
        float colorSamplings = 0;
        // System.out.println("Reading is starting");
        int index = 0;
        while (index < 19) {
            int idcolor = InitComp.color.getColorID();
            colorSamplings += idcolor;
            index = index + 1;

        }
        x = (colorSamplings) / 20;

        if (Math.round(x) == 2 || Math.round(x) == 3 || Math.round(x) == 4 || Math.round(x) == 5 || Math.round(x) == 6 || Math.round(x) == 7) {
            return true;
        }
        // else if (Math.round(x)==0.0) return true;
        if (Math.round(x) == 0 || Math.round(x) == 1) return false;
        return waitBrick();
    }
}