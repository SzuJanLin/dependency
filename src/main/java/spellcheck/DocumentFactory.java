package spellcheck;

import java.io.IOException;

public class DocumentFactory implements DocInterfaceFactory{

    public DocumentSource getDoc() {
        DocumentSource value;
        try {
            value = new URLDocumentSource();
            return value;
        }catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
