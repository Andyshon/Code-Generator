package Stubs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class LayoutGenerator {


    private StringBuilder stringBuilder;
    private static String temp_path = "/Users/andyshon/Documents/0Android projects/projects App Test/AppMaker_Tests/AppMaker_test_1/app/src/main/java/com/andyshon/appmaker_test_1";


    public LayoutGenerator () {
        stringBuilder = new StringBuilder();
    }

    public void build() {
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout\n" +
                "    xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"match_parent\"\n" +
                "    android:orientation=\"vertical\">\n" +
                "\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/" + GlobalStubs._class_name.toLowerCase() + "_id\"\n" +
                "        android:layout_width=\"fill_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:visibility=\"gone\" />\n" +
                "\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/" + GlobalStubs._class_name.toLowerCase() + "_name\"\n" +
                "        android:layout_width=\"fill_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:paddingLeft=\"6dip\"\n" +
                "        android:paddingTop=\"6dip\"\n" +
                "        android:textSize=\"22sp\"\n" +
                "        android:textStyle=\"bold\" />\n" +
                "\n" +
                "</LinearLayout>");

        createModelFile(stringBuilder);
    }

    private static void createModelFile (StringBuilder stringBuilder) {

        String[] mas = temp_path.split("/java/");
        String path = mas[0].concat("/res/layout/" + GlobalStubs._layout_adapter_name + ".xml");

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(stringBuilder.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
