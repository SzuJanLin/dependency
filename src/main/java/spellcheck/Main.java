
package spellcheck;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
			URLDocumentSource urlDocumentSource = new URLDocumentSource();
			DictionarySource dictionarySource = new FileDictionary("dict.txt");
			WordExtractor extractor = new WordExtractor("\\p{Alpha}+","\\p{Alpha}+");
			SpellingChecker checker = new SpellingChecker(urlDocumentSource,dictionarySource,extractor);
			SortedMap<String, Integer> mistakes = checker.check(args[0]);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

