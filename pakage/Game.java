package pakage;

import java.util.Arrays;

public class Game {

	static int Table2D [][] = new int [100][8];      //  <--------- Data Table
	static int totalBotWins = 0;                        //  <--------- Bot Wins Counter
	static int totalPlayerWins = 0;                    //  <--------- Player Wins Counter

	////////////  THIS FUNCTION TAKE FOR EXAMPLE "ROCK" AND RETURNS WHAT WINS ROCK "PAPER"  /////////
	public static int Negative (int a) {
		if (a>0 && a<4) {
			if (a == 1) {return 2;}else if (a == 2) {return 3;}else {return 1;}
		}else {
			System.out.println("~~~~~ Initialization Negative type error ~~~~~");
			return 0;
		}	
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

		for (int i = 0; i < 20 ; i++) {
			//@@@@@@@@@@@@@@@@ START " i " NUMBER OF GAMES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			//~~~~~~~~ BOT IS RANDOM ~~~~~~~~~~//
			types Bot = new types (((int)(Math.random()*3)+1));
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			
			//~~~~~~~ PLAYER IS RANDOM ~~~~~~~~//
			int number = 0;
			while (!(number >0 && number < 4)) {
				number = ((int)(Math.random()*3)+1);
			}
			types Player2 = new types (number);
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			
			//~~~~~ GAME SCORE (1 IS BOT WINS - 2 IS PLAYER WINS - 0 IS A DRAW)  ~~~~//
			int score = Bot.VS(Player2);
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

			//~~~~~~~~~~~~~~~~~~~~~~~ FILLING THE TABLE WITH DATA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			Table2D[i][0] = i ;                                        //   <--------- Game No.
			Table2D[i][1] = Bot.type ;                            //   <--------- Bot Type
			Table2D[i][2] = Player2.type ;                      //   <--------- Player Type
			Table2D[i][4] = Negative(Bot.type) ;              //   <--------- What Wins Bot 
			Table2D[i][5] = Negative(Player2.type) ;        //   <--------- What Wins Player
			Table2D[i][3] = score ;                                //   <--------- Winner (Bot:1,Player:2) 
			Table2D[i+1][6] = score ;                            //   <--------- Previous Game Who Won (RetroSpective)
			if (score == 2) {                                         //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				Table2D[i+1][7] = Negative(Player2.type);//
			}else if (score == 1) {                                 //   <--------- Previous Game What Wins Previous Winner (RetroSpective)
				Table2D[i+1][7] = Negative(Bot.type);      //
			}                                                              //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

			//~~~~~~~~~ SCORE COUNTER ~~~~~~~~~~//
			if (score != 0) {
				if (score == 1) {
					totalBotWins++;
				}else if (score == 2) {
					totalPlayerWins++;
				}
			}
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			
			//@@@@@@@@@@@@@@@@@@@@@@@@ END OF GAME @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		}

		//~~~~~~~~~~~~~~~~ PRINTING DATA TABKE AND SCORE ~~~~~~~~~~~~~~~~~~~~~//
		System.out.println("\n"
				+ "Table2D Data Info : \n\n"
				+ " |  Game No. "
				+ " |  Bot Type "
				+ " |  Player Type "
				+ " |  Winner (Bot:1,Player:2) "
				+ " |  What Wins Bot "
				+ " |  What Wins Player "
				+ " |  Previous Game Who Won "
				+ " |  Previous Game What Wins Previous Winner"
				+ "\n");
		for (int i = 0; i < 10; i++) {
			System.out.println(Arrays.toString(Table2D[i]));
		}
		System.out.println("Score ->  Bot :"+totalBotWins+"     Player2 :"+totalPlayerWins);
       //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	}       // <------- MAIN CLOSE BRACET
}           // <------- WHOLE CLASS CLOSE BRACET
