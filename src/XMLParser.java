import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
	private List<Item> itemList = new ArrayList<Item>();
	private Item item;
	private StringBuilder text;

	public List<Item> getFoodList() {
		return itemList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName + ", qName: " + qName);
		text = new StringBuilder();
		if (qName.equals("item")) {
			item = new Item();
		//	item.setId((Integer.parseInt(attributes.getValue("id"))));
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase());
		switch (tagName) {
		case ID:
			item.setId(Integer.parseInt(text.toString()));
			break;
		case NAME:
			item.setName(text.toString());
			break;
		case DAILYPRICE:
			item.setDailyPrice((float) Double.parseDouble(text.toString()));
			break;
		case CONDITION:
			item.setCondition(text.toString());
			break;
		case ITEM:
			itemList.add(item);
			item = null;
			break;

		}
	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}
}
