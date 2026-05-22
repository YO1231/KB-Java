package PM.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        String sourceFile = "C:\\KB-Java\\src\\PM\\stream\\StreamMappingExample.java";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(sourceFile);
            int byteData;
            while((byteData = fileInputStream.read()) != -1){
                System.out.println(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
