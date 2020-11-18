
package spellcheck;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class SpellingChecker {
    private final DocumentSource documentSource;
    private final DictionarySource dictionarySource;
    private final SourceExtractor sourceExtractor;

    public SpellingChecker(DocumentSource documentSource, DictionarySource dictionarySource, SourceExtractor sourceExtractor) {
        this.documentSource = documentSource;
        this.dictionarySource = dictionarySource;
        this.sourceExtractor = sourceExtractor;
    }

	public SortedMap<String, Integer> check(String uri) throws IOException {

		// download the document content
		//
		String content = documentSource.getContent(uri);

		// extract words from the content
		//

		List<String> words = sourceExtractor.extract(content);

		// find spelling mistakes
		//
		SortedMap<String, Integer> mistakes = new TreeMap<>();

        for (String word : words) {
            if (!dictionarySource.isValidWord(word)) {
                if (mistakes.containsKey(word)) {
                    int oldCount = mistakes.get(word);
                    mistakes.put(word, oldCount + 1);
                } else {
                    mistakes.put(word, 1);
                }
            }
        }

		return mistakes;
	}
}

