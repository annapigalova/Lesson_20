import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		XMLParser handler = new XMLParser();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("RentalShopItems.xml"));

		reader.setFeature("http://xml.org/sax/features/validation", true);
	
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
	
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		List<Item> menu = handler.getFoodList();
		for (Item food : menu) {
			System.out.println(food);
		}

	}

}
