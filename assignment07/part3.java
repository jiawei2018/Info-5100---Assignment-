package assignment07;

public class part3 {

	public static void main(String args[]){

	}
	
	

}

	class Tool {
		protected int strength;
		protected char type;
		protected int tmpO;
		protected int tmpI;
		void setStrength(int strength) {
			this.strength=strength;
		}

		public boolean fight(Tool tool) {
			return false;
		}
	}//class
	
	
	class Paper extends Tool{
		public Paper(int strength) {
			this.setStrength(strength);
			this.type='p';
		}
		@Override
		public boolean fight(Tool tool) {
			if(tool.type == 's') {
				tmpI= strength/2;
				tmpO = tool.strength*2;
			}else if(tool.type == 'r') {
			    tmpI = strength*2;
			    tmpO = tool.strength /2;
			}else {
				tmpI=tmpO=0;
			}
			return tmpI>tmpO;
		}
	}//class
	
	
	class Rock extends Tool{
		public Rock(int strength) {
			this.setStrength(strength);
			this.type='r';
		}
		@Override
		public boolean fight(Tool tool) {
			if(tool.type == 'p') {
				tmpI= strength/2;
				tmpO = tool.strength*2;
			}else if(tool.type == 's') {
			    tmpI = strength*2;
			    tmpO = tool.strength /2;
			}else {
				tmpI=tmpO=0;
			}
			return tmpI>tmpO;
		}
	}//class
	
	
	class Scissors extends Tool{
		public Scissors(int strength) {
			this.setStrength(strength);
			this.type = 's';
		}
		@Override
		public boolean fight(Tool tool) {
			if(tool.type == 'r') {
				tmpI= strength/2;
				tmpO = tool.strength*2;
			}else if(tool.type == 'p') {
			    tmpI = strength*2;
			    tmpO = tool.strength /2;
			}else {
				tmpI=tmpO=0;
			}
			return tmpI>tmpO;
		}
	}//end class
 	
	