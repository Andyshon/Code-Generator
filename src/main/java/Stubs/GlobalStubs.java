package Stubs;

public class GlobalStubs {


    static int _tabCounter = 0;
    public static String _Path_folder, _Path_package;


    static final String _class_signature = "public class ";
    public static String _class_name;
    public static String _layout_adapter_name;


    /*
     * todo: Brackets
     * */

    static final String _figure_brackets_1 = " {\n";
    static final String _figure_brackets_2 = "}\n";
    static final String _round_brackets_1 = "(";
    static final String _round_brackets_2 = ")";


    /*
     * todo: Access modifiers
     * */

    static final String _modifier_private = "private ";
    static final String _modifier_public =  "public ";
    static final String _modifier_protected = "protected ";
    static final String _modifier_default = "";

    static final String _method_modifier_void = "void ";

    static final String _method_getter = "get";
    static final String _method_setter = "set";

    static final String _return = "return ";
    static final String _keyword_this = "this.";

    static final String _operand_equals = " = ";
    static String _operand_semicolon = ";\n";


    /*
     * todo: Type of variables
     * */

    public static final String _variable_string = "String ";
    public static final String _variable_int = "int ";
    public static final String _variable_float = "float ";
    public static final String _variable_double = "double ";
    public static final String _variable_bool = "boolean ";


    /*
    * todo: Adapters imports
    * */

    public static String _adapter_imports =
            "import android.content.Context;\n" +
            "import android.view.LayoutInflater;\n" +
            "import android.view.View;\n" +
            "import android.view.ViewGroup;\n" +
            "import android.widget.ArrayAdapter;\n" +
            "import android.widget.TextView;\n" +
            "\n" +
            "import java.util.ArrayList;\n";

}
