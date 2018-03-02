package assignment06;

public class IceCream extends DessertItem {
	// public static final double COSTOFIC = 1.99;
	int perPrice;

	public IceCream(String name, int perPrice) {
		this.perPrice = perPrice;
		this.name = name;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return perPrice;
	}

	public String toString() {
		String line1, g1;
		g1 = super.calcuGaps(super.formatName(name), DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
		line1 = super.formatName(name) + g1 + DessertShoppe.cents2dollarsAndCentsmethod(perPrice);
		return line1;
	}

}
