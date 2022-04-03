package Agents;

import Layer1_Dev.InitComp;
import Layer1_Dev.dev1;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import lejos.utility.Delay;

public class ShredAgent  extends Agent {
    static boolean stop=false;
    static boolean stop1=false;
    static boolean back=false;
    public static boolean restart=false;
public static int count=0;
    @Override
    public void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {

                ACLMessage Message = receive();
                if (Message != null) {
                    if (count>1 && Message.getContent().equals("Dropped")) {
                        stop =false;
                        back=false;
                    }
                    System.out.println(Message.getContent());
                    /** According the message received :
                     * If Message.getContent= Brick received ==> Stop motors
                     * If Message.getContent= Brick is stuck ==> Stop motors and backward of conveyor 1 then restart them
                     */
                    if (Message.getContent().equals("Brick received")){
                        System.out.println(Message.getContent());
                        stop=true;
                        stop1=true;
                        dev1.stopconvoyor1();
                        Delay.msDelay(1);
                        dev1.stoptshrederMotor();
                        Delay.msDelay(1);
                        //stop=false;
                    }
                    if (Message.getContent().equals("Brick is stuck")){
                        back=true;
                        System.out.println(Message.getContent());
                        InitComp.motor1.stop();
                        Delay.msDelay(1);
                        InitComp.motor1.setSpeed(200);
                        Delay.msDelay(1);
                        InitComp.motor1.backward();
                        Delay.msDelay(1000);
                        InitComp.motor1.stop();
                        Delay.msDelay(1);
                        restart=true;
                       // count=1;
                     //   stop=false;
                    }

                    ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
                    addBehaviour(parallelBehaviour);
                    /** Simple Behaviour to start conveyor 1 and shredder motor with stop conditions (first task of shredder Agent)**/
                    parallelBehaviour.addSubBehaviour(new Behaviour() {
                        @Override
                        public void action() {
                            try {
                                if (dev1.ultrasonicSensor() > 100 && Message.getContent().equals("Dropped")) {
                                    dev1.startconvoyor1();
                                    Delay.msDelay(1);
                                    dev1.startshrederMotor();
                                    count++;
                                } else {
                                    dev1.stopconvoyor1Umergency();
                                    Delay.msDelay(1);
                                    dev1.stoptshrederUmergency();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public boolean done() {
                            if (stop || back) return true;
                            else return false;
                        }
                    });
                    /** Simple Behaviour to re-start conveyor 1 and shredder motor with stop conditions (after solving of stuck product)**/
                    parallelBehaviour.addSubBehaviour(new Behaviour() {
                        @Override
                        public void action() {
                            //if (restart) {
                            try {
                                //  while (true) {
                                if (restart && dev1.ultrasonicSensor() > 100 && Message.getContent().equals("Brick is stuck")) {
                                    dev1.startconvoyor1();
                                    Delay.msDelay(1);
                                    dev1.startshrederMotor();
                                   //  count=1;
                                } else {
                                    dev1.stopconvoyor1Umergency();
                                    Delay.msDelay(1);
                                    dev1.stoptshrederUmergency();
                                }

                                //     }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                        //   }

                        @Override
                        public boolean done() {
                            if (stop1) return true;
                            else return false;
                        }
                    });

                }

                else {
                    block();
                }
            }
        });
    }
}

