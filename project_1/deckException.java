package porject_1_jw;

public class deckException extends Exception {
	int size;
	public deckException(int size){
		this.size= size;
	}
	
	public String toString() {
		return("Error message : index out of bound in deck-cards index = "+size  );
	}
	

}
