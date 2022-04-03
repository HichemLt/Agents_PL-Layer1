package Layer1_Dev;

import lejos.utility.Delay;

public class DropSensor {


static boolean call_mode =false;



    public static boolean isProductReady() {

        if (!call_mode){
        InitComp.Colorsensor.getRGBMode();

        call_mode=true;
        }
            int idcolor = InitComp.Colorsensor.getColorID();
        //System.out.println("tries  "+idcolor);
       // while (true) {

            if (idcolor == 2 || idcolor == 3 || idcolor == 4 || idcolor == 5 || idcolor == 6 || idcolor == 7) {
                System.out.println("idcolor " + idcolor);
                 return true;

            } else {
                Delay.msDelay(1000);

                System.out.println("Wrong color or no product");
             isProductReady();
             return isProductReady();
                //  }
                //   }
            }
       // } end of
    }
/*public static boolean re_read() {
    if (!call_mode) {
        InitComp.Colorsensor.getRGBMode();

        call_mode = true;
    }
    int idcolor = InitComp.Colorsensor.getColorID();
    if (idcolor == 2 || idcolor == 3 || idcolor == 4 || idcolor == 5 || idcolor == 6 || idcolor == 7) {
        System.out.println("idcolor " + idcolor);
        return true;

    } else {
        Delay.msDelay(1000);
        System.out.println("Wrong color or no product");
        //  System.out.println("idcolor " + idcolor);
        return false;
    }
}*/}
