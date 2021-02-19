package pakage;

import java.util.Arrays;

public class Game {
	
	static int Table2D [][] = new int [100][7];

static int totalCompWins = 0;
static int totalPlayerWins = 0;


public static int Negative (int a) {
	if (a>0 && a<4) {
		if (a == 1) {return 2;}else if (a == 2) {return 3;}else {return 1;}
	}else {
		System.out.println("~~~~~ Initialization Negative type error ~~~~~");
		return 0;
	}	
}



	public static void main(String[] args) {

		for (int i = 0; i < 9 ; i++) {
////////////////////////////////////// START OF GAME ////////////////////////////////////////////////////////////////////////////////////////
			types Comp = new types (((int)(Math.random()*3)+1));
			int number = 0;
			while (!(number >0 && number < 4)) {
				number = ((int)(Math.random()*3)+1);
			}
			types Player2 = new types (number);
			Table2D[i][0] = i ;
			Table2D[i][1] = Comp.type ;
			Table2D[i][2] = Player2.type ;
			Table2D[i][4] = Negative(Comp.type) ;
			Table2D[i][5] = Negative(Player2.type) ;

			int score = Comp.VS(Player2);
			
			Table2D[i][3] = score ;
			Table2D[i+1][6] = score ;
			
			if (score != 0) {
				if (score == 1) {
					totalCompWins++;
				}else if (score == 2) {
					totalPlayerWins++;
				}
			}
//////////////////////////////////// END OF GAME //////////////////////////////////////////////////////////////////////////////////
		}

System.out.println("Score ->  Comp :"+totalCompWins+"     Comp2 :"+totalPlayerWins);
System.out.println("\nTable2D Data Info : \n\n |  Game No.  |  Comp Type  |  Player Type  |  Winner (Comp:1,Player:2)  |  What Wins Comp  |  What Wins Player  |  Previous Game Who Won  |\n");
for (int i = 0; i < 10; i++) {
	System.out.println(Arrays.toString(Table2D[i]));
}




	}


}
