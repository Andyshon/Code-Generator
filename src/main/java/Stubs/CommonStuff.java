package Stubs;

public class CommonStuff {

    public static String getPackageName (String temp_path) {
        String[] packageFullPath = temp_path.split("/java/");
        String packagePath = (packageFullPath[1]).replaceAll("/", ".").concat(";");
        String keyPackage = "package ";
        packagePath = keyPackage.concat(packagePath);

        return packagePath;
    }

}
