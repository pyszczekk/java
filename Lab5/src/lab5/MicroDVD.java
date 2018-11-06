/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

/**
 *
 * @author pyszczekk
 */
public class MicroDVD {
    private BufferedReader fileReader;
    private int delay;
    private String [] value = new String[3];
    
    public void delay (String in, String out, int delay, int fps) throws Exception{
        openFile(in);
        String line;
        String filename = out;
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        this.delay = delay / 1000 * fps;
        int i = 1; // licznik linii;
        while ((line = fileReader.readLine()) != null) {
            if (check(line, i)) {
                int a = Integer.parseInt(value[0]) + this.delay;
                int b = Integer.parseInt(value[1]) + this.delay;
                if(a<0) a=0;
                if(b<0) b=0;
                String caption = "{" + a + "}" + "{" + b + "}" + value[2];
                writer.println(caption);
            }
            i++;
        }
        writer.close();
    }
     private boolean check(String line, int index) throws Exception{
        Pattern p = Pattern.compile("\\{([0-9]+)\\}\\{([0-9]+)\\}(.*)");
        Matcher matcher = p.matcher(line);
        if(matcher.find()) {
            if (Integer.parseInt(matcher.group(1)) <= Integer.parseInt(matcher.group(2))) {

                for (int i = 0; i < 3; i++) {
                    value[i] = matcher.group(i+1);
                }
                return true;
            }
            else {
                throw new Exception("Wrong value in frame at line: " + index + "\n" + line);
            }
        }
        else {
            throw new Exception("Incorrect sequence in frame at line: " + index + "\n" + line);
        }
    }
    private void openFile(String fileToOpen) throws IOException {
        Path file = Paths.get(fileToOpen);
        InputStream in = Files.newInputStream(file);
        this.fileReader = new BufferedReader(new InputStreamReader(in));    
    }

    
}
