package botplay;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Loads commands from an xml file into a given bot.
 * Created by Nathan on 2/03/2015.
 */
public final class XMLCommandLoader {
    public static void LoadFromXML(TwitchCommanderBot botToLoadTo, String fileName) {

    }

    public static void SaveToXML(TwitchCommanderBot botToSave, String fileName) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("tcb-v1.0");
        doc.appendChild(rootElement);

        // staff elements
        Element staff = doc.createElement("Commands");
        rootElement.appendChild(staff);


        for(String key: botToSave.getCommandMap().keySet()){
            Element newCommand = doc.createElement(key);

            newCommand.appendChild(doc.createTextNode(botToSave.getCommandMap().get(key).toString()));
        }

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);
    }
}
