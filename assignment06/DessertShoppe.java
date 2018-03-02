package assignment06;

import java.math.BigDecimal;
//import java.text.DecimalFormat;

public class DessertShoppe {
	public final static double TAXRATE = 0.065; /// seattle 10.5%
	public final static String SHOPNAME = "M & M ";
	public final static int NAMEMAXLEN = 36;
	public final static int COSTWIDTH = 7; // MAX of one deal is $ 9999.99
	public final static int RESTPART = 13;

	public static double cents2dollarsAndCentsmethod(int cents) {
		String res;
		double tmp;
		int dollar;
		int remain;
		String restCents;

		dollar = cents / 100;
		remain = cents - dollar * 100;
		if (remain<10) {
			restCents="0"+remain;
		}else
			restCents=String.valueOf(remain);
		
	    if (dollar <1) {
			dollar=0;
			res = "."+restCents;
		}else
        res = dollar+"."+restCents;//error if less than 10 cents ,will be 
        tmp=Double.valueOf(res);
		return tmp;
	}//end method

}//end class
