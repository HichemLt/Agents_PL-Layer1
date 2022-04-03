package Agents;


import Layer2_Dev.InitComp2;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;


public class Layer2Container {
    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.instance();
            String A="192.168.0.164";//the @ip of the machine which contains the main container
            String B="192.168.0.111";// the local @ ip of the machine
            ProfileImpl p=new ProfileImpl(A, 1099, null, false);
            p.setParameter(Profile.LOCAL_HOST, B);
            p.setParameter(Profile.LOCAL_PORT, "1099");
            AgentContainer agentcontainer =runtime.createAgentContainer(p);

        Layer2Container.start();

            AgentController buildAgent=agentcontainer.createNewAgent("BuildAgent",
                    "Layer2_Dev.BuildAgent",new Object[]{});

            AgentController pushagent=agentcontainer.createNewAgent("PushAgent",
                    "Layer2_Dev.PushAgent",new Object[]{});

           buildAgent.start();
           pushagent.start();
          //  sortAgents.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void start() {
        InitComp2.initComponents();

    }

}
