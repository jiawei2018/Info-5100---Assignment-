package assignment06;

import java.util.*;

public class Checkout {

	// vector
	Vector<DessertItem> v1 = new Vector<DessertItem>();
	DessertShoppe d1 = new DessertShoppe();

	// public void enterItem(Object object) {
	//
	//
	// }
	// public String Checkout() {//?may be a arraylist
	//
	// return null;
	// }

	public int numberOfItems() {
		return v1.size();
	}

	public void enterItem(DessertItem item) {
		v1.add(item);
	}

	public void clear() {
		v1.clear();
		// d1=null;
	}

	public double totalCost() {
		int tmp = 0;

		for (DessertItem p : v1) {
			// System.out.println(tmp+" <> " +p.getCost());
			tmp += p.getCost();

		}
		// d1.cents2dollarsAndCentsmethod(tmp);
		return DessertShoppe.cents2dollarsAndCentsmethod(tmp);
	}

	public double totalTax() {
		double tmp = DessertShoppe.TAXRATE * Double.valueOf(totalCost()) * 100;// dollar to cents
		int tax = Integer.valueOf(String.valueOf(Math.round(tmp)));
		double res = DessertShoppe.cents2dollarsAndCentsmethod(tax);
		// System.out.println(tmp);
		return res;
		// return tax in cents
	}

	public String toString() {
		// this is the final output and it should look like:
		/*
		 * M & M Dessert Shoppe --------------------
		 * 
		 * 2.25 lbs. @ 3.99 /lb. Peanut Butter Fudge 8.98 Vanilla Ice Cream 1.05 Hot
		 * Fudge Sundae with Choc. Chip Ice Cream 1.95 4 @ 3.99 /dz. Oatmeal Raisin
		 * Cookies 1.33
		 * 
		 * Tax .87 Total Cost 14.18
		 */
		String shopLine, dishLine;
		shopLine = "M & M Dessert Shoppe";
		dishLine = "----------------------";
		shopLine = DessertItem.calcuGaps(shopLine) + shopLine;
		dishLine = DessertItem.calcuGaps(dishLine) + dishLine;
		System.out.println(shopLine);
		System.out.println(dishLine);
		System.out.println("\n");

		for (DessertItem p : v1) {
			// System.out.println(tmp+" <> " +p.getCost());
			System.out.println(p);

		}
		String taxLine, tCostLine;
		String taxGap, tC;
		taxGap = DessertItem.calcuGaps("Tax", totalTax());
		tC = DessertItem.calcuGaps("Total Cost", totalCost());

		taxLine = "Tax" + taxGap + totalTax();
		tCostLine = "Total Cost" + tC + String.valueOf(totalCost() + totalTax());

		System.out.println("\n");
		System.out.println(taxLine);
		System.out.println(tCostLine);

		return "\n";
	}

}
