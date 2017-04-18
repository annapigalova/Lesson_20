
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParser {

	public static List<Item> process(XMLStreamReader reader) throws XMLStreamException {
		List<Item> itemList = new ArrayList<Item>();
		Item item = null;
		ItemTagName elementName = null;

		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = ItemTagName.getElementTagName(reader.getLocalName());

				switch (elementName) {
				case ITEM:
					item = new Item();
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case ID:
					item.setId(Integer.valueOf(text.toString()));
					break;

				case NAME:
					item.setName(text);
					break;

				case DAILYPRICE: 
					item.setDailyPrice(Double.valueOf(text.toString()));
					break;

				case CONDITION:
					item.setCondition(text);
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = ItemTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case ITEM:
					itemList.add(item);
				}
			}
		}
		return itemList;
	}

}
