import Stubs.GlobalStubs;
import Stubs.GlobalStubsController;

import javax.swing.*;
import java.util.HashMap;

public class Controller {

    private JFrame main;


    public Controller (JFrame component) {
        this.main = component;
    }


    public void choosePath (String path_type) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Выберите папку главного проекта");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(main) == JFileChooser.APPROVE_OPTION) {
            if (path_type.equals("main_folder")) {
                GlobalStubs._Path_folder = String.valueOf(chooser.getSelectedFile());
            }
            else if (path_type.equals("package")) {
                GlobalStubs._Path_package = String.valueOf(chooser.getSelectedFile());
            }
        }
        else { System.out.println("No Selection "); }

    }

    public void createAdapterDesignPattern (JFrame frame) {

        HashMap<String,String> map = new HashMap<String, String>();
        map.put("name", GlobalStubs._variable_string);
        map.put("id", GlobalStubs._variable_string);
        map.put("age", GlobalStubs._variable_int);

        GlobalStubsController.generateAdapterDesignPattern(map, frame);
    }

}
