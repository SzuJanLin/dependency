
package spellcheck;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
			DocumentSource urlDocumentSource = new DocumentFactory().getDoc();
			DictionarySource dictionarySource = new DictionaryFactory("dict.txt").getDictionary();
			SourceExtractor extractor = new SourceFactory("\\p{Alpha}+","\\p{Alpha}+").getSourceExtractor();
			SpellingChecker checker = new SpellingChecker(urlDocumentSource,dictionarySource,extractor);
			SortedMap<String, Integer> mistakes = checker.check(args[0]);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

