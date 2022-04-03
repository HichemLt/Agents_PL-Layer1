package Agents;

import Layer1_Dev.dev1;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import lejos.robotics.Color;
import lejos.utility.Delay;

import java.util.Timer;
import java.util.TimerTask;

import static jade.lang.acl.ACLMessage.CONFIRM;


public class SortAgent extends Agent {
    static boolean index=false;
    static boolean index1=false;
    static int count=0;
    @Override
    public void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {   /** waiting messages */
                ACLMessage Message = receive();
                if (Message != null) {
                //  if (!index) {
                    time();
                    if (count>1) {
                        index1=false;
                    }
                 // }
                    System.out.println("Sort agent " + Message.getContent());
                 while (true) {
                     Idcolor1();

       break;          }


                } else {
                    block();
                }
            }
        });
    }

    public boolean Idcolor() {
        count++;
       // int color = dev1.CheckColor();
        if (dev1.CheckColor() == 2) {
            index1 = true;
            Stopmotors();
          //  Delay.msDelay(500);
            if (dev1.CheckColor()==2) {
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                Pushproduct();
                Delay.msDelay(1);
                dev1.FirstStartconvoyor2();
          }

        return true;

        } else if (dev1.CheckColor() == 3) {
            index1 = true;
            Stopmotors();
         //   Delay.msDelay(500);
           if (dev1.CheckColor()==3) {
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                Pushproduct();
                Delay.msDelay(1);
                dev1.SecondStartconvoyor2();
         }

            return true;
        } else if (dev1.CheckColor() == 4) {
            index1 = true;
            Stopmotors();
          //  Delay.msDelay(500);
          if (dev1.CheckColor()!=0) {  /***/
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                Pushproduct();
                Delay.msDelay(1);
                dev1.ThirdStartconvoyor2();
          }
            return true;
        } else if (dev1.CheckColor() == 5) {
            index1 = true;
            Stopmotors();
            //Delay.msDelay(500);
            if (dev1.CheckColor()==5) {
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                SendMessageToBuildAgent();
                Delay.msDelay(1);
                dev1.FourthStartconvoyor2();
           }
            return true;
            //  Brickstuck();
        } else {

            return Idcolor();
        }
    }

    /**
     * Send a massage to Shredder Agent to stop the motors
     **/

    public void Stopmotors() {
        ACLMessage messageTemplate = new ACLMessage(CONFIRM);
        messageTemplate.addReceiver(new AID("ShredAgent", AID.ISLOCALNAME));
        messageTemplate.setContent("Brick received");
        send(messageTemplate);
      /*  dev1.stoptshrederMotor();
        Delay.msDelay(1);
        dev1.stopconvoyor1();*/
    }

    public void SendMessageToBuildAgent() {
        ACLMessage messageTemplate = new ACLMessage(CONFIRM);
        messageTemplate.addReceiver(new AID("BuildAgent", AID.ISLOCALNAME));
        messageTemplate.setContent("Red product");
        send(messageTemplate);
      /*  dev1.stoptshrederMotor();
        Delay.msDelay(1);
        dev1.stopconvoyor1();*/
    }

    /**
     * Send a massage to Push agent to push the product
     **/
    public void Pushproduct() {
        ACLMessage messageTemplate = new ACLMessage(ACLMessage.INFORM);
        messageTemplate.addReceiver(new AID("PushAgent", AID.ISLOCALNAME));
        messageTemplate.setContent("Push product");
        send(messageTemplate);
    }

    /**
     * Send a massage to Shredder Agent to solve the stuck problem
     **/

    public void Brickstuck() {
        ACLMessage messageTemplate = new ACLMessage(CONFIRM);
        messageTemplate.addReceiver(new AID("ShredAgent", AID.ISLOCALNAME));
        messageTemplate.setContent("Brick is stuck");
        send(messageTemplate);
       // dev1.stoptshrederMotor();
      //  Delay.msDelay(1);
     //   dev1.stopconvoyor1();
    }

        /** Waiting 5 seconds then check product color **/
    /**If the color is stuck restart the task1 (checking) after 2 seconds **/

    public boolean time() {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if ((dev1.NoBrick() == 1||dev1.NoBrick() == 0)&&!index1) {
                   Brickstuck();
                 //  index=true;
                    System.out.println("indexxxx"+index1);
                   t.cancel();
                }
                else {

                    t.purge();
                }

            }
        };
        t.schedule(task,7000);
        //t.scheduleAtFixedRate(task,7000,8000);
    return true;}
    public boolean Idcolor1() {
        count++;
        // int color = dev1.CheckColor();
        if (dev1.CheckColor() != 0||dev1.CheckColor() != 1) {
            index1 = true;
            Stopmotors();
             Delay.msDelay(10);
            int  color= dev1.CheckColor();
            if (color==2) {
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                Pushproduct();
                Delay.msDelay(1);
                dev1.FirstStartconvoyor2();

            return true;}
         else    if (color==3) {
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                Pushproduct();
                Delay.msDelay(1);
                dev1.SecondStartconvoyor2();

          return true;}
            else if (dev1.CheckColor() == 4) {
                    System.out.println("color: "+dev1.CheckColor());
                    Delay.msDelay(1);
                    Pushproduct();
                    Delay.msDelay(1);
                    dev1.ThirdStartconvoyor2();
               return true;}
            else if (dev1.CheckColor() == 5) {
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                SendMessageToBuildAgent();
                Delay.msDelay(1);
                dev1.FourthStartconvoyor2();
                return true;}
          /*


         else if ( == 3) {
            index1 = true;
            Stopmotors();
            //   Delay.msDelay(500);

            return true;
        } else if (dev1.CheckColor() == 4) {
            index1 = true;
            Stopmotors();
            //  Delay.msDelay(500);
            if (dev1.CheckColor()!=0) {  *//***//*
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                Pushproduct();
                Delay.msDelay(1);
                dev1.ThirdStartconvoyor2();
            }
            return true;
        } else if (dev1.CheckColor() == 5) {
            index1 = true;
            Stopmotors();
            //Delay.msDelay(500);
            if (dev1.CheckColor()==5) {
                System.out.println("color: "+dev1.CheckColor());
                Delay.msDelay(1);
                SendMessageToBuildAgent();
                Delay.msDelay(1);
                dev1.FourthStartconvoyor2();
            }
            return true;
            //  Brickstuck();
        } else {*/
        }
        return Idcolor1();

    }
}