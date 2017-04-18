
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		SaxParser handler = new SaxParser();
		reader.setContentHandler(handler);

		reader.parse(new InputSource("RentalShopItems.xml"));

		List<Item> itemList = handler.getItemList();
		for (Item item : itemList) {
			System.out.println(item);
		}

		// Stax Part
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			InputStream input = new FileInputStream("RentalShopItems.xml");
			XMLStreamReader readerStax = inputFactory.createXMLStreamReader(input);
			List<Item> itmList = StaxParser.process(readerStax);

			for (Item item : itmList) {
				System.out.println(item);
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

}
