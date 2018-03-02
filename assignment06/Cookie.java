package assignment06;

public class Cookie extends DessertItem {
	int nums;
	// int perPrice;

	public Cookie(String name, int nums, int perPrice) {
		this.name = name;
		this.perPrice = perPrice;
		this.nums = nums;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		int res = nums * perPrice / 12;
		return res;
	}

	public String toString() {
		String line1, line2, g1;
		line1 = nums + " dz. " + String.valueOf(perPrice) + "/dz.";
		g1 = super.calcuGaps(super.formatName(name), DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
		line2 = super.formatName(name) + g1 + DessertShoppe.cents2dollarsAndCentsmethod(getCost());
		return line1 + "\n" + line2;
	}

}
