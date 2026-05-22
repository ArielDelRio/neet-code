package arrayshashing.stringencodeanddecode;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {
    public String encode(List<String> strs) {
        String encoded = "";
        for (String str : strs) {
            encoded += str.length() + "#" + str;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        char[] charArr = str.toCharArray();
        String wordLength = "";

        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '#') {
                int startingWordIndex = i + 1;
                int endingWordIndex = startingWordIndex + Integer.parseInt(wordLength);
                list.add(str.substring(startingWordIndex, endingWordIndex));
                i = endingWordIndex - 1;
                wordLength = "";
            } else {
                wordLength += charArr[i];
            }
        }
        return list;
    }
}
