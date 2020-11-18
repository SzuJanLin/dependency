
package spellcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class WordExtractor implements SourceExtractor {


	WordExtractor(String wordPattern, String delimiterPattern){
		initializePatterns(wordPattern,delimiterPattern);
	}

	Pattern wordPattern = null;
	Pattern delimiterPattern = null;

	public List<String> extract(String content) {

		content = content.toLowerCase();
		
		List<String> words = new ArrayList<>();

		//Pattern wordPattern = Pattern.compile("\\p{Alpha}+");
		//Pattern delimiterPattern = Pattern.compile("[^\\p{Alpha}]+");

		Scanner scanner = new Scanner(content);
		scanner.useDelimiter(delimiterPattern);

		while (scanner.hasNext(wordPattern)) {
			String word = scanner.next(wordPattern);
			words.add(word);
		}

		return words;
	}


	public void initializePatterns(String wordPattern, String delimiterPattern) {
		this.wordPattern = Pattern.compile(wordPattern);
		this.delimiterPattern = Pattern.compile(delimiterPattern);
	}
}

