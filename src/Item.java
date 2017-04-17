
public class Item {
	private int id;
	private String name;
	private float dailyPrice;
	private String condition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {

		return "ID: " + getId() + System.lineSeparator() + "Name: " + getName() + System.lineSeparator()
				+ "Daily Price: " + getDailyPrice() + System.lineSeparator() + "Condition: " + getCondition();
	}

}
