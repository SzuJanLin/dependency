
package spellcheck;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class FileDictionary implements DictionarySource{

	private Set<String> words;

	public FileDictionary(String fileName) throws IOException {
        initializeWords(fileName);
	}



	public boolean isValidWord(String word) {
		return words.contains(word);
	}


    public void initializeWords(String source) throws IOException {
        try (Scanner scanner = new Scanner(new File(source))) {
            words = new TreeSet<>();
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                words.add(word);
            }
        }
    }
}

