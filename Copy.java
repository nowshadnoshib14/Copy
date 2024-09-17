import java.io.*;

public class Copy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("please enter source file and destination only");
        }

        String sourcePath = args[0];
        String destinationPath = args[1];

        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        copyFile(sourceFile, destinationFile);

    }

    public static void copyFile(File sourceFile, File destinationFile) {

        if (!sourceFile.exists()) {
            System.out.println("source file doesnt exists");
            return;
        }
        if (destinationFile.isDirectory()) {
            System.out.println("destination is not a file");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            PrintWriter writer = new PrintWriter(destinationFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
            System.out.println("file copied successfully");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

    };

}