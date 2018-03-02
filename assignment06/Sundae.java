package assignment06;

public class Sundae extends IceCream {

	private String top;
	private int topPrice;

	public Sundae(String name, int perPrice, String top, int topPrice) {
		super(name, perPrice);
		this.top = top;
		this.topPrice = topPrice;
	}

	public String getSundaeName() {
		return name + " with " + top;
	}

	@Override
	public int getCost() {
		return perPrice + topPrice;
	}

	public String toString() {
		String line1, line2, g1;
		line1 = super.formatName(top) + " with ";
		g1 = super.calcuGaps(name, DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
		line2 = name + g1 + DessertShoppe.cents2dollarsAndCentsmethod(getCost());
		return line1 + "\n" + line2;
	}

}
