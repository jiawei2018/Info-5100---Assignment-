package assignment07;

public class part01 {

	public static void main(String[] args) throws MyIndexOutOfBoundException {

		int[] a = new int[8];

		int b = -1;
		try {
			if(b > a.length-1) throw new MyIndexOutOfBoundException(0,a.length,b);
			if(b < 0) throw new MyIndexOutOfBoundException(0,a.length,b);
		}

		finally {
			//
		}
	}//end main
}//end class

class MyIndexOutOfBoundException extends Exception {
	int index, lowerBound, upperBound;

	public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
		this.index = index;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public String toString() {
		return "Error Message:Index : " + index + ", but Lower bound: " + lowerBound + ", Upper bound: " + upperBound;
	}

}