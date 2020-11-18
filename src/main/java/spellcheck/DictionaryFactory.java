package spellcheck;

import java.io.IOException;

public class DictionaryFactory implements DictionaryInterfaceFactory{
    String value;
    DictionaryFactory(String value){
        this.value=value;
    }

    public DictionarySource getDictionary() {
        try {
            return new FileDictionary(value);
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

}
