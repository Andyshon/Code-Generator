package Stubs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static Stubs.GlobalStubs._class_name;


public class AdapterGenerator {


    private StringBuilder stringBuilder;
    private static String temp_path = "/Users/andyshon/Documents/0Android projects/projects App Test/AppMaker_Tests/AppMaker_test_1/app/src/main/java/com/andyshon/appmaker_test_1";
    private String adapterClassName;


    public AdapterGenerator () {
        stringBuilder = new StringBuilder();
    }

    public void build() {
        String nameLowPlusS = GlobalStubs._class_name;
        nameLowPlusS = nameLowPlusS.concat("s").toLowerCase();

        String tvName, tvId;
        tvId = GlobalStubs._class_name.toLowerCase() + "_id";
        tvName = GlobalStubs._class_name.toLowerCase() + "_name";

        adapterClassName = _class_name.concat("Adapter");
        String class_name_low = GlobalStubs._class_name.toLowerCase();

        stringBuilder.append(CommonStuff.getPackageName(temp_path)).append("\n\n");
        stringBuilder.append(GlobalStubs._adapter_imports).append("\n");

        stringBuilder.append("public class " + adapterClassName + " extends ArrayAdapter<" + GlobalStubs._class_name + "> {\n\n" +
                "    public " + adapterClassName + "(Context context, ArrayList<" + GlobalStubs._class_name + "> " + nameLowPlusS + ") {\n" +
                "       super(context, 0, " + nameLowPlusS + ");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public View getView(int position, View convertView, ViewGroup parent) {\n" +
                "       // Get the data item for this position\n" +
                "       " + GlobalStubs._class_name + " " + class_name_low +" = getItem(position);    \n" +
                "       // Check if an existing view is being reused, otherwise inflate the view\n" +
                "       if (convertView == null) {\n" +
                "          convertView = LayoutInflater.from(getContext()).inflate(R.layout." + GlobalStubs._layout_adapter_name + ", parent, false);\n" +
                "       }\n" +
                "       // Lookup view for data population\n" +
                "       TextView tvId = (TextView) convertView.findViewById(R.id." + tvId + ");\n" +
                "       TextView tvName = (TextView) convertView.findViewById(R.id." + tvName + ");\n" +
                "       // Populate the data into the template view using the data object\n" +
                "       if (" + class_name_low + " != null) {\n" +
                "\t       tvId.setText(" + class_name_low + "." + "getId());\n" +
                "\t       tvName.setText(" + class_name_low + ".getName());\n" +
                "       }\n" +
                "       // Return the completed view to render on screen\n" +
                "       return convertView;\n" +
                "   }\n" +
                "}");

        createModelFile(stringBuilder);
    }

    private void createModelFile (StringBuilder stringBuilder) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(temp_path + "/" + adapterClassName + ".java"));
            out.write(stringBuilder.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
