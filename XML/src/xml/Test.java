package xml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public class Test {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, TransformerConfigurationException, IOException {
        XML magic = new XML();
        magic.generarDoc();
        magic.generarXml();
    //writeXml(doc, System.out);
    }
    
}
