import Stubs.GlobalStubs;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    private Controller controller;

    public JFrame mainFrame;
    private JTextField jTextField1, jTextField2;
    private JLabel label_folder, label_package;


    public Main(){

        controller = new Controller(mainFrame);
        controller = new Controller(mainFrame);

        JButton btn_choose_folder = new JButton("Set folder");
        JButton btn_choose_package = new JButton("Set package");
        JButton btn_create_adapter = new JButton("Build adapter");

        btn_choose_folder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.choosePath("main_folder");
                label_folder.setText(GlobalStubs._Path_folder);
            }
        });
        btn_choose_package.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.choosePath("package");
                String cutPath1 = GlobalStubs._Path_package.substring(0,15);
                String cutPath2 = GlobalStubs._Path_package.substring(GlobalStubs._Path_package.length()-15, GlobalStubs._Path_package.length());
                String cutPath = cutPath1.concat(".../").concat(cutPath2);
                label_package.setText(cutPath);
            }
        });
        btn_create_adapter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GlobalStubs._class_name = jTextField1.getText().trim();
                GlobalStubs._layout_adapter_name = jTextField2.getText().trim();
                controller.createAdapterDesignPattern(mainFrame);
            }
        });

        label_folder = new JLabel(GlobalStubs._Path_folder);
        label_package = new JLabel(GlobalStubs._Path_package);


        final JLabel label = new JLabel("Model class name:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField1 = new JTextField("User");
        final JLabel label2 = new JLabel("Layout adapter name:");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField2 = new JTextField("list_entry");

        Container panel = new Container();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);


        mainFrame = new JFrame("Code Generator - Android Design Patterns");
        mainFrame.setSize(600,450);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new GridLayout(1, 1));

        JLabel headerLabel = new JLabel("", JLabel.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());

        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);

        headerLabel.setText("Auto Generator Android Design Patterns");
        headerLabel.setSize(100,20);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        headerLabel.setBorder(border);


        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        //panel3.setBackground(Color.white);
        panel3.setSize(300,300);
        GridLayout layout3 = new GridLayout(0,2);
        layout3.setHgap(10);
        layout3.setVgap(10);

        panel3.setLayout(layout3);
        panel3.add(btn_choose_folder);
        panel3.add(label_folder);
        panel3.add(btn_choose_package);
        panel3.add(label_package);

        panel3.add(label);
        panel3.add(jTextField1);
        panel3.add(label2);
        panel3.add(jTextField2);
        panel3.add(btn_create_adapter);

        controlPanel.add(panel3);

        mainFrame.setVisible(true);
    }

}
