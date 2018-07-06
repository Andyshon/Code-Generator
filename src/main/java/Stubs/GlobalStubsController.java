package Stubs;

import javax.swing.*;
import java.util.HashMap;


public class GlobalStubsController {


    /*
     * todo: Method called from Controller -> generate Adapter Design Pattern
     * */

    public static void generateAdapterDesignPattern (HashMap<String,String> _vars, JFrame frame) {

        ModelGenerator modelGenerator = new ModelGenerator();
        modelGenerator.build(_vars);

        LayoutGenerator layoutGenerator = new LayoutGenerator();
        layoutGenerator.build();

        JOptionPane.showMessageDialog(frame, "Design Pattern created in your Android Studio project!",
                "Finish",JOptionPane.PLAIN_MESSAGE);

        //writeToFile(generateLayout());
        //writeToFile(generateLayoutListEntry());
        //writeToFile(generateMainActivity());
        //writeToFile(generateAdapter());
    }
}
