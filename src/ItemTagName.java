
public enum ItemTagName {
	ID, NAME, DAILYPRICE, CONDITION, ITEM, ITEMS;

	public static ItemTagName getElementTagName(String element) {
		switch (element) {
		case "id":
			return ID;
		case "name":
			return NAME;
		case "dailyPrice":
			return DAILYPRICE;
		case "condition":
			return CONDITION;
		case "item":
			return ITEM;
		case "items":
			return ITEMS;
		default:
			throw new EnumConstantNotPresentException(ItemTagName.class, element);
		}
	}
}