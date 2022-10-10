package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private BufferedReader bufferedReader;

    public Input(String path) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(path));
    }

    public List<Character> read() throws IOException {
        List<Character> characterList = new ArrayList<>();
        int symbol = bufferedReader.read();
        while (symbol != -1) {
            char c = (char) symbol;
            characterList.add(c);
            symbol = bufferedReader.read();
        }
        bufferedReader.close();
        return characterList;
    }
}
