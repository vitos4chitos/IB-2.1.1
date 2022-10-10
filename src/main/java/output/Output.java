package output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Output {

    private BufferedWriter bufferedWriter;

    public Output(String path) throws IOException {
        bufferedWriter= new BufferedWriter(new FileWriter(path));
    }

    public void write(String string) throws IOException {
        bufferedWriter.write(string);
        bufferedWriter.close();
    }
}
