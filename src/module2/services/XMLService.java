package module2.services;

import module2.interfases.WritableReadable;
import module2.models.Bouquet;
import module2.models.Flower;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Map;

public class XMLService implements WritableReadable {

    protected Document document;

    public final static String folderPath = "src/module2/resultsXML";
    private File file;

    public XMLService() {
        File dir = new File(folderPath);
        if (!dir.exists()) dir.mkdir();
        String date = new SimpleDateFormat("ddMM-hhmmss").format(new Date());
        this.file = new File(dir + "/" + date + ".xml");
    }

    public void writeToSource(Bouquet bouquet, Object... objects) {
        int cost = Integer.parseInt(String.valueOf(objects[0]));
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .newDocument();

            Element root = document.createElement("bouquet");
            Attr attr = document.createAttribute("cost");
            attr.setValue(Integer.toString(cost));
            root.setAttributeNode(attr);
            document.appendChild(root);

            Element flowers = document.createElement("flowers");
            root.appendChild(flowers);

            for (Map.Entry<Flower, Integer> entity : bouquet.getFlowers().entrySet()) {
                Element flower = document.createElement("flower");
                Attr flowerAttr = document.createAttribute("quantity");
                flowerAttr.setValue(Integer.toString(entity.getValue()));
                flower.setAttributeNode(flowerAttr);
                flower.appendChild(document.createTextNode(entity.getKey().getFlowerName()));
                flowers.appendChild(flower);
            }
            //document.normalizeDocument();

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(this.file);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromSource() {
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            while ((line = reader.readLine()) != null) System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
