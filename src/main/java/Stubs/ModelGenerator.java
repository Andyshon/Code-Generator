package Stubs;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static Stubs.GlobalStubs.*;

public class ModelGenerator {


    private String temp_path = "/Users/andyshon/Documents/0Android projects/projects App Test/AppMaker_Tests/AppMaker_test_1/app/src/main/java/com/andyshon/appmaker_test_1";

    private StringBuilder stringBuilder;
    private StringBuilder stringBuilderConstructor;
    private StringBuilder stringBuilderGettersSetter;
    private StringBuilder params;
    private StringBuilder bodyParams;

    private HashMap<String, String> _Variables;


    public ModelGenerator () {
        stringBuilder = new StringBuilder();
        stringBuilderGettersSetter = new StringBuilder();
        stringBuilderConstructor = new StringBuilder("\n\t").append(_modifier_public).append(" ").append(_class_name).append(" ");
    }

    public void build (HashMap<String, String> _Variables) {

        this._Variables = _Variables;

        params = new StringBuilder("(");
        bodyParams = new StringBuilder();

        createModelFile(generateModelForAdapter());
    }


    private StringBuilder generateModelForAdapter () {

        generateClassPackage();

        generateClassDeclaration(stringBuilder);
        generatePrivateVariables(stringBuilder);

        stringBuilder.append(stringBuilderConstructor);

        stringBuilder.append(stringBuilderGettersSetter);

        stringBuilder.append(_figure_brackets_2);
        _tabCounter--;


        System.out.println(stringBuilder);
        return stringBuilder;
    }

    private void generateClassPackage() {

        stringBuilder.append(CommonStuff.getPackageName(temp_path));
        insertLine(stringBuilder);
        insertLine(stringBuilder);
    }


    private void generateClassDeclaration (StringBuilder stringBuilder) {

        String _class_signature_full = _class_signature.concat(_class_name);
        stringBuilder.append(_class_signature_full);
        stringBuilder.append(_figure_brackets_1);
        _tabCounter++;
    }


    private void generatePrivateVariables (StringBuilder stringBuilder) {

        Iterator iterator = _Variables.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();

            insertTabulation(stringBuilder);
            stringBuilder.append(_modifier_private);
            stringBuilder.append(me.getValue());
            stringBuilder.append(me.getKey());
            stringBuilder.append(_operand_semicolon);


            if (!iterator.hasNext()) {
                generateConstructor(true, me.getValue().toString(), me.getKey().toString());
            }
            else {
                generateConstructor(false, me.getValue().toString(), me.getKey().toString());
            }
            generateGetterOnFly(stringBuilderGettersSetter, me.getValue().toString(), me.getKey().toString());
            generateSetterOnFly(stringBuilderGettersSetter, me.getValue().toString(), me.getKey().toString());
        }

    }


    /*
    * todo: Generate Constructor
    * */

    private void generateConstructor (boolean isLast, String var_type, String var_name) {

        String endLine;
        String coma;
        if (isLast) {
            coma = ") {";
            endLine = "\n\t}";
        }
        else {
            coma = ", ";
            endLine = "\n";
        }

        params.append(var_type).append(" ").append(var_name).append(coma);

        bodyParams.append("\t\t").append("this.").append(var_name).append(" = ").append(var_name).append(";").append(endLine);

        if (isLast) {
            stringBuilderConstructor.append(params).append("\n").append(bodyParams).append("\n");
        }
    }


    /*
     * todo: Generate getter
     * */

    private void generateGetterOnFly (StringBuilder stringBuilder, String var_type, String var_name) {

        insertLine(stringBuilder);
        insertTabulation(stringBuilder);
        stringBuilder.append(_modifier_public);
        stringBuilder.append(var_type);
        stringBuilder.append(_method_getter);

        String capitalLetter = String.valueOf(var_name.charAt(0)).toUpperCase();
        String var_nameUp = var_name.replaceFirst(String.valueOf(var_name.charAt(0)), capitalLetter);

        stringBuilder.append(var_nameUp);
        stringBuilder.append(_round_brackets_1);
        stringBuilder.append(_round_brackets_2);
        stringBuilder.append(_figure_brackets_1);
        _tabCounter++;
        insertTabulation(stringBuilder);
        stringBuilder.append(_return);
        stringBuilder.append(_keyword_this);
        stringBuilder.append(var_name);
        stringBuilder.append(_operand_semicolon);
        _tabCounter--;
        insertTabulation(stringBuilder);
        stringBuilder.append(_figure_brackets_2);
    }


    /*
     * todo: Generate setter
     * */

    private void generateSetterOnFly (StringBuilder stringBuilder, String var_type, String var_name) {

        insertLine(stringBuilder);
        insertTabulation(stringBuilder);
        stringBuilder.append(_modifier_public);
        stringBuilder.append(_method_modifier_void);
        stringBuilder.append(_method_setter);

        String capitalLetter = String.valueOf(var_name.charAt(0)).toUpperCase();
        String var_nameUp = var_name.replaceFirst(String.valueOf(var_name.charAt(0)), capitalLetter);

        stringBuilder.append(var_nameUp);
        stringBuilder.append(_round_brackets_1);
        stringBuilder.append(var_type);
        stringBuilder.append(var_name);
        stringBuilder.append(_round_brackets_2);
        stringBuilder.append(_figure_brackets_1);
        _tabCounter++;
        insertTabulation(stringBuilder);
        stringBuilder.append(_keyword_this);
        stringBuilder.append(var_name);
        stringBuilder.append(_operand_equals);
        stringBuilder.append(var_name);
        stringBuilder.append(_operand_semicolon);
        _tabCounter--;
        insertTabulation(stringBuilder);
        stringBuilder.append(_figure_brackets_2);
    }




    /*
     * todo: Utils
     * */

    private void insertTabulation (StringBuilder stringBuilder) {
        String str = "";
        for (int i=0; i<_tabCounter; i++) {
            str = str.concat("\t");
        }
        stringBuilder.append(str);
    }


    private void insertLine (StringBuilder stringBuilder) {
        stringBuilder.append("\n");
    }


    private void createModelFile (StringBuilder stringBuilder) {

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(temp_path + "/" + _class_name + ".java"));
            out.write(stringBuilder.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
