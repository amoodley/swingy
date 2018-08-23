package amoodley.utilities;

import java.io.BufferedReader;
import java.io.FileReader;

public class readFile {

    public static String getContent(String filename){

        String line = null;
        String content = null;
        BufferedReader reader = null;

        try {

            reader  = new BufferedReader(new FileReader(filename));
            content = "";
        } catch (Exception e) {
            Log.out("getContent() " + e.getMessage());
        }
        return (content);
    }
}
