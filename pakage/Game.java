package pakage;

import java.util.Arrays;

public class Game {

	static int Table2D [][] = new int [100][20];      //  <--------- Data Table
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

	//////////////////////////////// STATISTICAL & PSYCHOLOGICAL GUESS ////////////////////////////////////////////////////////////////////
	public static int Guess (int a[][]) {

		int Log20[][] = ArrayManipulation.CopyOnlyLast20Rows(a);
		int guess1 = 0;
		int guess2 = 0;
		int DidntAppearLongTime = 0;
		int AppearedTooMuch = 0;
		int RockStat[] = ArrayManipulation.Col2Row(Log20,14,0,19);
		int RockStats[] = ArrayManipulation.Array1DStatisticProccessing(RockStat);
		int PaperStat[] = ArrayManipulation.Col2Row(Log20,15,0,19);
		int PaperStats[] = ArrayManipulation.Array1DStatisticProccessing(PaperStat);
		int ScissorsStat[] = ArrayManipulation.Col2Row(Log20,16,0,19);
		int ScissorsStats[] = ArrayManipulation.Array1DStatisticProccessing(ScissorsStat);
		int RockMissing10Lines = 0;
		int PaperMissing10Lines = 0;
		int ScissorsMissing10Lines = 0;
		
		int guessPercantageRock = 0;
		int guessPercantagePaper = 0;
		int guessPercantageScissors = 0;
		
		/*
		System.out.println("______________________________________________");
		for (int k = 0; k < Log20.length; k++) {
			System.out.println(Arrays.toString(Log20[k]));
		}
		System.out.println("______________________________________________");
		*/
		
		
		if ((RockStats[0]+PaperStats[0]+ScissorsStats[0]) == 0) {
			if ((RockStats[1]+PaperStats[1]+ScissorsStats[1]) >0 ) {
				DidntAppearLongTime = ArrayManipulation.LargestOutof3(RockStats[1],PaperStats[1],ScissorsStats[1]);
			}else if ((RockStats[2]+PaperStats[2]+ScissorsStats[2])  > 0 ) {
				AppearedTooMuch = ArrayManipulation.LargestOutof3(RockStats[1],PaperStats[1],ScissorsStats[1]);
			}
		}else if ((RockStats[0]+PaperStats[0]+ScissorsStats[0]) >= 1) {
			for (int q = 1; q < Log20.length; q++) {
				for (int w = 14; w < Log20[0].length; w++) {
					if (Log20[q][w]==0) {
					int temp = ArrayManipulation.SmallestOutof3(Log20[q-1][w],Log20[q-1][w+1],Log20[q-1][w+2]);
					if (temp == 1) {
						RockMissing10Lines = 1;
					}else if (temp == 2) {
						PaperMissing10Lines = 1;
					}else if (temp ==3) {
						ScissorsMissing10Lines = 1;
					}
					break;}
				}
			}
		}
		/*     //  <-----  Eyes
		System.out.println("\nRockMissing10Lines = "+RockMissing10Lines+"\nPaperMissing10Lines = "+PaperMissing10Lines+"\nScissorsMissing10Lines = "+ScissorsMissing10Lines);
		System.out.println("DidntAppearLongTime = "+DidntAppearLongTime+"\nAppearedTooMuch = "+AppearedTooMuch);
		 */

		//###### when player wins they tend to play the same move ##################################//
		//###### when player lose they tend to play the move that would beat their previous move ##########//
		if (Log20[Log20.length-2][3] == 2) {
			guess1 = Log20[Log20.length-2][2];
			if (guess1==1) {
				guessPercantageRock = guessPercantageRock+24;
			}else if (guess1==2) {
				guessPercantagePaper = guessPercantagePaper+24;
			}else if (guess1==3) {
				guessPercantageScissors = guessPercantageScissors+24;
			}
		}else if (Log20[Log20.length-2][3] == 1) {
			guess2 = Negative(Log20[Log20.length-2][2]);
			if (guess2==1) {
				guessPercantageRock = guessPercantageRock+24;
			}else if (guess2==2) {
				guessPercantagePaper = guessPercantagePaper+24;
			}else if (guess2==3) {
				guessPercantageScissors = guessPercantageScissors+24;
			}
		}
		//####################################################################################//
		
		//################# final percantage calculation ###########################//
		if (RockMissing10Lines>0) {
			guessPercantageRock = guessPercantageRock+51;
		}
		if (PaperMissing10Lines>0) {
			guessPercantagePaper = guessPercantagePaper+51;
		}
		if (ScissorsMissing10Lines>0) {
			guessPercantageScissors = guessPercantageScissors+51;
		}

		if (DidntAppearLongTime==1) {
			guessPercantageRock = guessPercantageRock+16;
		}else if (DidntAppearLongTime==2) {
			guessPercantagePaper = guessPercantagePaper+16;
		}else if (DidntAppearLongTime==3) {
			guessPercantageScissors = guessPercantageScissors+16;
		}

		if (AppearedTooMuch==1) {
			guessPercantageRock = guessPercantageRock-16;
		}else if (AppearedTooMuch==2) {
			guessPercantagePaper = guessPercantagePaper-16;
		}else if (AppearedTooMuch==3) {
			guessPercantageScissors = guessPercantageScissors-16;
		}
		
		//###################################################################//
		System.out.println("Guess : Rock "+guessPercantageRock+"%    Paper "+guessPercantagePaper+"%    Scissors "+guessPercantageScissors+"%");   //  <----  Eyes
		return ArrayManipulation.LargestOutof3(guessPercantageRock,guessPercantagePaper,guessPercantageScissors);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	public static void main(String[] args) {

		for (int i = 0; i < 70 ; i++) {
			//@@@@@@@@@@@@@@@@ START " i " NUMBER OF GAMES @@@@@@@@@@@@@@@@@@@@@@@@@@@@@

			//~~~~~~~~ BOT IS RANDOM ~~~~~~~~~~//
			types Bot;
			if (i>40) {
				Bot = new types (Negative(Guess(Table2D)));	
			}else {
				Bot = new types (((int)(Math.random()*3)+1));
			}			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

			//~~~~~~~~ PLAYER'S CHOISE ~~~~~~~~~//
			int number = 0;
			while (!(number >0 && number < 4)) {
				//number = ((int)(Math.random()*3)+1); // <--- Random
				number = MyConsole.readInt("");   //   <--- Human Selection
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
			}else if (score == 1) {                                 //   <--------- What Wins Previous Winner (RetroSpective)
				Table2D[i+1][7] = Negative(Bot.type);      //
			}                                                              //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if (i > 10) {
				int BOTLast10Games [] = ArrayManipulation.Col2Row(Table2D,1, (i-10) , i);	
				int BOTLast10GamesPerc [][] = ArrayManipulation.AppearanceCounter(BOTLast10Games);
				if (BOTLast10GamesPerc[0].length>2) {
					Table2D[i][8] = BOTLast10GamesPerc[1][0];    //  <---- Bot Type - Rock -  Quantity Percantage Last 10 Games
					Table2D[i][9] = BOTLast10GamesPerc[1][1];    //  <---- Bot Type - Paper -  Quantity Percantage Last 10 Games
					Table2D[i][10] = BOTLast10GamesPerc[1][2];    //  <---- Bot Type - Scissors -  Quantity Percantage Last 10 Games
				}
			}
			if (i > 20) {
				int BOTLast20Games [] = ArrayManipulation.Col2Row(Table2D,1, (i-20) , i);	
				int BOTLast20GamesPerc [][] = ArrayManipulation.AppearanceCounter(BOTLast20Games);
				if (BOTLast20GamesPerc[0].length>2) {
					Table2D[i][11] = BOTLast20GamesPerc[1][0];    //  <---- Bot Type - Rock -  Quantity Percantage Last 20 Games
					Table2D[i][12] =BOTLast20GamesPerc[1][1];    //  <---- Bot Type - Paper -  Quantity Percantage Last 20 Games
					Table2D[i][13] = BOTLast20GamesPerc[1][2];    //  <---- Bot Type - Scissors -  Quantity Percantage Last 20 Games
				}
			}
			if (i > 10) {
				int PLAYERLast10Games [] = ArrayManipulation.Col2Row(Table2D,2, (i-10) , i);	
				int PLAYERLast10GamesPerc [][] = ArrayManipulation.AppearanceCounter(PLAYERLast10Games);
				if (PLAYERLast10GamesPerc[0].length>2) {
					Table2D[i][14] = PLAYERLast10GamesPerc[1][0];    //  <---- PLAYER Type - Rock -  Quantity Percantage Last 10 Games
					Table2D[i][15] = PLAYERLast10GamesPerc[1][1];    //  <---- PLAYER Type - Paper -  Quantity Percantage Last 10 Games
					Table2D[i][16] = PLAYERLast10GamesPerc[1][2];    //  <---- PLAYER Type - Scissors -  Quantity Percantage Last 10 Games
				}
			}
			if (i > 20) {
				int PLAYERLast20Games [] = ArrayManipulation.Col2Row(Table2D,2, (i-20) , i);	
				int PLAYERLast20GamesPerc [][] = ArrayManipulation.AppearanceCounter(PLAYERLast20Games);
				if (PLAYERLast20GamesPerc[0].length>2) {
					Table2D[i][17] = PLAYERLast20GamesPerc[1][0];    //  <---- PLAYER Type - Rock -  Quantity Percantage Last 20 Games
					Table2D[i][18] = PLAYERLast20GamesPerc[1][1];    //  <---- PLAYER Type - Paper -  Quantity Percantage Last 20 Games
					Table2D[i][19] = PLAYERLast20GamesPerc[1][2];    //  <---- PLAYER Type - Scissors -  Quantity Percantage Last 20 Games
				}
			}
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
				+ " |  What Wins Previous Winner"
				+ "\n");

		System.out.println("Score ->  Bot :"+totalBotWins+"     Player2 :"+totalPlayerWins);
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//


		//~~~~~~~~~~~~~~~~~~~ GUESS ~~~~~~~~~~~~~~~~~~~~~~~~~~//

		System.out.println(Guess(Table2D));


		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//





	}       // <------- MAIN CLOSE BRACET
}           // <------- WHOLE CLASS CLOSE BRACET
