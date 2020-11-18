package spellcheck;

import java.util.List;

public interface SourceExtractor {


    List<String> extract(String content);
    void initializePatterns(String wordPattern, String delimiterPattern);

}
