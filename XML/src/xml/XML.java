package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.io.PrintWriter;


public class XML {
    
    private Document doc;
    
    public XML() throws ParserConfigurationException{
     DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b =f.newDocumentBuilder();
        doc = b.newDocument();
    }

    public void generarDoc() throws ParserConfigurationException, TransformerException{
     
     Element Persona = doc.createElement("Persona");
     doc.appendChild(Persona);
     Element mujer = doc.createElement("Mujer");
     
     Element persona = doc.createElement("persona");
     Persona.appendChild(persona);
     persona.setAttribute("profesión", "cantante");
     
     Element nombre = doc.createElement("nombre");
     nombre.setTextContent("Elsa");
     persona.appendChild(nombre);
 
      Element nacimiento = doc.createElement("fecha_de_nacimiento");
      // add persona to root
      Persona.appendChild(nacimiento);

      Element dia = doc.createElement("dia");
      dia.setTextContent("18");
      nacimiento.appendChild(dia);

      Element mes = doc.createElement("mes");
      mes.setTextContent("6");
      nacimiento.appendChild(mes);

      Element ano = doc.createElement("año");
      ano.setTextContent("1996");
      nacimiento.appendChild(ano);

      Element ciudad =doc.createElement("ciudad");
      ciudad.setTextContent("Pamplona");
      Persona.appendChild(ciudad); 
      
      writeXml(doc, System.out);

  }

  // write doc to output stream
  private static void writeXml(Document doc,
                               OutputStream output)
          throws TransformerException {

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();

      // pretty print
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(output);

      transformer.transform(source, result);

  }
  
      public void generarXml() throws TransformerConfigurationException, FileNotFoundException, IOException, TransformerException{
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();
       
        Source source = new DOMSource(doc);
        File file = new File("C:\\Users\\emili\\Desktop\\prueba3.xml");
        FileWriter fw = new FileWriter (file);
        PrintWriter pw = new PrintWriter (fw);
        Result r = new StreamResult (pw);
       
        transformer.transform(source, r);
    }

    }
    

