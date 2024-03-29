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

            while ((line = reader.readLine()) != null)
            {
                line = line.trim();
                if (line != null)
                    content += line + "\n";
            }
            reader.close();
        } catch (Exception e) {
            Log.out("getContent() " + e.getMessage());
        }
        return (content);
    }
}
