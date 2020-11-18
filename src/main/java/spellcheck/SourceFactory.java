package spellcheck;

public class SourceFactory implements SourceInterfaceFactory{

    String wordPattern;
    String delimiterPattern;

    SourceFactory(String wordPattern,String delimiterPattern){
        this.wordPattern = wordPattern;
        this.delimiterPattern = delimiterPattern;
    }

    public SourceExtractor getSourceExtractor(){
        return new WordExtractor(wordPattern,delimiterPattern);
    }

}
