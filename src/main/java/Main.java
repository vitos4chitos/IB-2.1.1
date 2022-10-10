import encryption.cesar.CesarMethod;
import input.Input;
import output.Output;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int offset = Integer.parseInt(args[0]);
        String pathOut = args[3];
        String path = args[2];
        String phrase = args[1];
        Input input = new Input(path);
        CesarMethod cesarMethod = new CesarMethod(alphabet, offset, phrase);
        Output output = new Output(pathOut);
        if(args[4].equals("e"))
            output.write(cesarMethod.encode(input.read()));
        if(args[4].equals("d"))
            output.write(cesarMethod.decode(input.read()));
    }
}
