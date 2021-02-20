package pakage;

public class types {
	
					//ROCK         = 1 
					//PAPER       = 2
					//SCISSORS = 3	 
	
	public String s = "none";    // <------ Rock or Paper or Scissors string
	int type = 0;                       // <------ 1 or 2 or 3 integer

	//~~~~~~~~~~~~~~~~~~~~~~~~ OBJECT BUILDER ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public types (int a) {
		if (a>0 && a<4) {
			this.type = a;
			if (a == 1) {this.s = "Rock";}else if (a == 2) {this.s = "Paper";}else {this.s = "Scissors";}
		}else {
			System.out.println("~~~~~ Initialization type error ~~~~~");
		}	
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~~~~~~~~~~~~~~~~ BASIC PRINTING OF OBJECT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	public void PrintType () {
		System.out.println("Hand : "+this.s+"  ["+this.type+"]");
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	//~~~~~~~~~~~ RETURNS THE WINNER AND PRINTS WHAT HAPPEND ~~~~~~~~~~~~~~~~~~//
	public int VS (types Player) {
		//``````````` IF DRAW `````````````````````````````````````````````````````````````````````````````````````````````//
		if (Player.type == this.type) {
			System.out.println("*** DRAW *** ");
			System.out.println("Bot = "+this.s+"        Player = "+Player.s);                          //<---- Eyes
			return 0;
		//````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````//
		}else {
			//``````````` IF OBJECT IS ROCK `````````````````````````````````````````````````````````````````````````//
		if (this.type == 1) {
			if (Player.type == 2) {
				System.out.println("Bot Lose");
				System.out.println("Computer = "+this.s+"        Player = "+Player.s);              //<---- Eyes
				return 2;
			}else {
				System.out.println("Bot Win");
		   System.out.println("Computer = "+this.s+"        Player = "+Player.s);                 //<---- Eyes
				return 1;
			}
		}
		//````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````//
		//``````````` IF OBJECT IS PAPER ```````````````````````````````````````````````````````````````````````````//
		if (this.type == 2) {
			if (Player.type == 3) {
				System.out.println("Bot Lose");
				System.out.println("Computer = "+this.s+"        Player = "+Player.s);              //<---- Eyes
				return 2;
			}else {
				System.out.println("Bot Win");
				System.out.println("Computer = "+this.s+"        Player = "+Player.s);              //<---- Eyes
				return 1;
			}
		}
		//````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````//
		//``````````` IF OBJECT IS SCISSORS  ````````````````````````````````````````````````````````````````````//
		if (this.type == 3) {
			if (Player.type == 1) {
				System.out.println("Bot Lose");
				System.out.println("Computer = "+this.s+"        Player = "+Player.s);              //<---- Eyes
				return 2;
			}else {
				System.out.println("Bot Win");
				System.out.println("Computer = "+this.s+"        Player = "+Player.s);              //<---- Eyes
				return 1;
			}
		}
		//````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````//
		System.out.println("Computer = "+this.s+"        Player = "+Player.s);                      //<---- Eyes
		}
		return 0;	
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

}

