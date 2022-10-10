package encryption.cesar;

import encryption.Encryption;

import java.util.List;

public class CesarMethod implements Encryption {

    private String alphabet;
    private String encryption;
    private int offset;
    private String phrase;

    public CesarMethod(String alphabet, int offset, String phrase){

        this.alphabet = alphabet;
        this.offset = offset;
        this.phrase = phrase;
        this.encryption = generateEncryption();
    }

    @Override
    public String encode(List<Character> characterList) {
        String answer = "";
        for (Character character : characterList) {
            int c = alphabet.indexOf(character);
            if (c != -1)
                answer += encryption.charAt(c);
            else
                answer += character;
        }
        return answer;
    }

    @Override
    public String decode(List<Character> characterList) {
        String answer = "";
        for (Character character : characterList) {
            int c = encryption.indexOf(character);
            if (c != -1)
                answer += alphabet.charAt(c);
            else
                answer += character;
        }
        return answer;
    }

    private String generateEncryption(){
        int correction = 0;
        String encryption = "";
        String en = "";
        String check;
        for(int i = 0; i < alphabet.length(); i++){
            check = (alphabet.substring(
                    (alphabet.length() + i - offset + correction) % alphabet.length(),
                    (alphabet.length() + i - offset + correction) % alphabet.length() + 1));
            while (phrase.contains(check)){
                correction += 1;
                check = (alphabet.substring(
                        (alphabet.length() + i - offset + correction) % alphabet.length(),
                        (alphabet.length() + i - offset + correction) % alphabet.length() + 1));
            }
            encryption += check;
        }
        if(offset <= alphabet.length() - phrase.length()) {
            encryption = encryption.substring(0, offset)
                    + phrase
                    + encryption.substring(offset, alphabet.length() - phrase.length());
            return encryption;
        }
        else{
            return null;

        }
//        encryption = encryption.substring(0, offset)
//                + phrase
//                + encryption.substring(offset, alphabet.length() - phrase.length());
//        return encryption;
    }

    public String getEncryption(){
        return encryption;
    }
}
