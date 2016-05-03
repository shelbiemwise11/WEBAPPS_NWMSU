
package wiseshelbie_project05;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class MetroAreaParser {
    private final DocumentBuilder builder;
    private final XPath path;


public MetroAreaParser() throws ParserConfigurationException{
    builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    path = XPathFactory.newInstance().newXPath();
}
        
 public ArrayList<MetroArea> getMetroAreaFromXMLFile(String fileName)
        throws SAXException, IOException, XPathExpressionException{
        Document doc = builder.parse(new File(fileName));
        int count = Integer.parseInt(path.evaluate("count(/metroAreaList/metroArea)", doc));

        ArrayList<MetroArea> metroAreaz = new ArrayList<>();
        for(int i = 1; i<=count; i++){
            String name = path.evaluate("/metroAreaList/metroArea[" + i + "]/name", doc);
            String country = path.evaluate("/metroAreaList/metroArea[" + i + "]/country", doc);
            double population = Double.parseDouble(path.evaluate("/metroAreaList/metroArea[" + i + "]/population", doc));
            double area = Double.parseDouble(path.evaluate("/metroAreaList/metroArea[" + i + "]/area", doc));
            metroAreaz.add(new MetroArea(name, country, population, area));
        }
     
     return metroAreaz;
 }       
        
        
}               