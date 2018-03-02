package assignment06;

public abstract class DessertItem {

	protected String name;
	protected int perPrice;

	public DessertItem() {
		// empty
	}

	public DessertItem(String string) {
	}

	public final String getName() {
		return name;
	}

	public abstract int getCost();

	public String formatName(String name) {
		// make long name to short like abcdef -> abc...
		String res;
		if (name.length() <= DessertShoppe.NAMEMAXLEN - DessertShoppe.RESTPART)
			return name;
		else {
			char[] rech = new char[DessertShoppe.NAMEMAXLEN - DessertShoppe.RESTPART];
			int lon = rech.length - 3;
			for (int i = 0; i < lon - 1; i++) {
				rech[i] = name.charAt(i);
			}

			res = String.valueOf(rech) + "...";
		}
		return res;
	}

	public static String calcuGaps(String string, double costs) {

		int j = string.length() + String.valueOf(costs).length();
		int gaps = DessertShoppe.NAMEMAXLEN - j;
		String res = "";
		for (int i = 0; i < gaps; i++) {
			res += " ";
		}
		return res;
	}

	public static String calcuGaps(String string) {
		int j = string.length();
		int gaps = (DessertShoppe.NAMEMAXLEN - j) / 2;
		String res = "";
		for (int i = 0; i < gaps; i++) {
			res += " ";
		}
		return res;
	}

}
