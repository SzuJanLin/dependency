package spellcheck;

import java.io.IOException;
import java.util.Set;

public interface DictionarySource {


    void initializeWords(String source) throws IOException;
    boolean isValidWord(String word);

}
