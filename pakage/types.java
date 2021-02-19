package pakage;

public class types {
/*
ROCK = 1 
PAPER = 2
SCISSORS = 3
*/		 
	public String s = "none";
	int type = 0;

	public types (int a) {
		if (a>0 && a<4) {
			this.type = a;
			if (a == 1) {this.s = "Rock";}else if (a == 2) {this.s = "Paper";}else {this.s = "Scissors";}
		}else {
			System.out.println("~~~~~ Initialization type error ~~~~~");
		}	
	}

	public void PrintType () {
		System.out.println("Hand : "+this.s+"  ["+this.type+"]");
	}
	
	public int VS (types Player) {
		/////////////// IF DRAW //////////////////////////////////////
		if (Player.type == this.type) {
			System.out.println("*** DRAW *** ");
			//System.out.println("Computer = "+this.s+"        Player = "+Player.s);
			return 0;
		/////////////////////////////////////////////////////////////////////
		}else {
		///////////// IF IM ROCK //////////////////////////////
		if (this.type == 1) {
			if (Player.type == 2) {
				System.out.println("Computer Lose");
			//	System.out.println("Computer = "+this.s+"        Player = "+Player.s);
				return 2;
			}else {
				System.out.println("Computer Win");
		   //System.out.println("Computer = "+this.s+"        Player = "+Player.s);
				return 1;
			}
		}
		//////////////////////////////////////////////////////////////
		///////////// IF IM PAPER //////////////////////////////
		if (this.type == 2) {
			if (Player.type == 3) {
				System.out.println("Computer Lose");
			//	System.out.println("Computer = "+this.s+"        Player = "+Player.s);
				return 2;
			}else {
				System.out.println("Computer Win");
			//	System.out.println("Computer = "+this.s+"        Player = "+Player.s);
				return 1;
			}
		}
		//////////////////////////////////////////////////////////////
		///////////// IF IM SCISSORS //////////////////////////////
		if (this.type == 3) {
			if (Player.type == 1) {
				System.out.println("Computer Lose");
			//	System.out.println("Computer = "+this.s+"        Player = "+Player.s);
				return 2;
			}else {
				System.out.println("Computer Win");
			//	System.out.println("Computer = "+this.s+"        Player = "+Player.s);
				return 1;
			}
		}
		//////////////////////////////////////////////////////////////
	//	System.out.println("Computer = "+this.s+"        Player = "+Player.s);
		}
		return 0;	
	}



	


}
