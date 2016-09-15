package module2.services;

import module2.models.Bouquet;
import module2.models.Flower;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class XMLService {

    protected Document document;

    public final static String folderPath = "src/module2/results/xml";
    private File file;

    public XMLService() {
        File dir = new File(folderPath);
        if (!dir.exists()) dir.mkdir();
        String date = new SimpleDateFormat("ddMM-hhmmss").format(new Date());
        this.file = new File(dir + "/" + date + ".xml");
    }

    public void writeToDocument(Bouquet bouquet, int cost) {
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

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(this.file);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
