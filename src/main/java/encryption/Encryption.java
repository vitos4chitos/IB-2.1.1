package encryption;

import java.util.List;

public interface Encryption {

    public String encode(List<Character> characterList);

    public String decode(List<Character> characterList);
}
