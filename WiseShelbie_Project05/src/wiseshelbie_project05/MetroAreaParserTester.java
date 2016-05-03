
package wiseshelbie_project05;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;


public class MetroAreaParserTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        
        MetroAreaParser idk = new MetroAreaParser();
        ArrayList<MetroArea> metros = idk.getMetroAreaFromXMLFile("metroInfo.xml");
        for (MetroArea metro: metros){
            System.out.println(metro.toString());
        }
    }
    
}
