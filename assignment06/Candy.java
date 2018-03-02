package assignment06;

public class Candy extends DessertItem {

	// private String name;
	private double weight;
	private int singlePirce;

	public Candy(String name, double weight, int singlePrice) {
		this.name = name;
		this.weight = weight;
		this.singlePirce = singlePrice;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		// singlePirce*weight;
		double tmp = singlePirce * weight;
		int res = Integer.valueOf(String.valueOf(Math.round(tmp)));
		return res;
	}

	public String toString() {
		// 4 @ 3.99 /dz.
		// Oatmeal Raisin Cookies 1.33
		String line1, line2, g1;
		line1 = weight + " lbs " + String.valueOf(DessertShoppe.cents2dollarsAndCentsmethod(singlePirce)) + "/lb.";
		g1 = super.calcuGaps(super.formatName(name), DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
		line2 = super.formatName(name) + g1 + DessertShoppe.cents2dollarsAndCentsmethod(getCost());

		return line1 + "\n" + line2;
	}

}
