package Stubs;

import javax.swing.*;
import java.util.HashMap;


public class GlobalStubsController {


    /*
     * todo: Method called from Controller -> generate Adapter Design Pattern
     * */

    public static void generateAdapterDesignPattern (HashMap<String,String> _vars, JFrame frame) {

        new ModelGenerator().build(_vars);

        new LayoutGenerator().build();

        new AdapterGenerator().build();

        //new MainActivityGenerator().build();

        JOptionPane.showMessageDialog(frame, "Design Pattern created in your Android Studio project!",
                "Finish",JOptionPane.PLAIN_MESSAGE);
        }
}
