package pakage;

import java.util.Arrays;

public class ArrayManipulation {

	//~~~~~~ TAKES COLUMN IN 2D ARRAY FROM RANGE OF INDEXS AND RETURN 1D ROW ARRAY ~~~~~~//
	public static int [] Col2Row (int a[][] , int colNum , int fromindex , int toindex) {
		int Row [] = new int [toindex-fromindex+1] ;
		for (int i = fromindex; i < toindex+1; i++) {
			Row [i-fromindex] = a[i][colNum];
		}
		return Row;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~~~~~~~~~~~~~~~~~~~~~~ TAKES 1D ARRAY , COUNTS APPEARANCES AND RETURNS 2D ARRAY ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	//~~~~~~ PercentageTable[0] IS VALUES ARRAY , PercentageTable[1] IS APPEARANCE OF THAT VALUE IN THE ARRAY IN PERCANTAGE ARRAY~~~~~~//
	//~~~~~~~~~~~~~~~~~~~~~~~~~~ EXAMPLE : {1,2,3,3} , PercentageTable[0] = {1,2,3} , PercentageTable[1] = {25,25,50} ~~~~~~~~~~~~~~~~~~~~~~~~~//
	public static int [][] AppearanceCounter (int a[]) {

		int Appearances [][] = new int [2][MinMaxReturn(a)[1]+1];
		for (int i = MinMaxReturn(a)[0] ; i < Appearances[0].length ; i++) {
			Appearances[0][i-MinMaxReturn(a)[0]] = i;
		}
		for (int i = 0 ; i < a.length ; i++) {
			Appearances[1][a[i]-MinMaxReturn(a)[0]]++;
		}
		double Total = 0;
		for (int i = 0; i < Appearances[0].length; i++) {
			Total = Total + Appearances[1][i];
		}
		int ActualNumbers = 0;
		for (int i = 0; i < Appearances[0].length; i++) {
			if (Appearances[1][i] != 0) {
				ActualNumbers++;
				double temp = (Math.round(((Appearances[1][i]/Total)*100000)));
				temp = temp/1000;
				//System.out.println(Appearances[0][i]+"   Appears for : "+temp+"%");  //  <---- Eyes
			}
		}
		int PercentageTable [][] = new int [2][ActualNumbers];
		for (int i = 0 , j = 0; i < Appearances[0].length; i++) {
			if (Appearances[1][i] != 0) {
				double temp = (Math.round(((Appearances[1][i]/Total)*100000)));
				temp = temp/1000;
				PercentageTable[0][j] = Appearances[0][i];
				PercentageTable[1][j] = (int)temp ;
				j++;
			}
		}
		return PercentageTable;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~ MINIMUM AND MAXIMUM VALUE OF 1D ARRAY , RETURNS 1D ARRAY , MinMax[0] = IS MINIMUM VALUE , MinMax[1] = IS MAXIMUM VALUE ~~~~//
	public static int[] MinMaxReturn (int a[]) {
		int MinMax [] = new int [2];
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= max) {
				max = a[i];
			}
		}
		int min = max;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= min) {
				min = a[i];
			}
		}
		MinMax[1] = max;
		MinMax[0] = min;
		return MinMax;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~~~~~~~~~ TAKES 2D ARRAY GOES ONE LINE BY ONE UNTIL a[i][0] IS ZERO ~~~~~~~~~~~~~~~~~~~//
	//~~~~~~~~~THEN GOES BACK 20 LINES AND RETURNS THE NEXT 20 LINES IN AN ARRAY ~~~~~~~~~~~~//
	public static int[][] CopyOnlyLast20Rows (int a[][]){
		int Log20[][] = new int [20][a[0].length];
		int i = 1;
		for (i = 1; i < a.length ;) {
			if (a[i][0] != 0) {
				i++;
			}else {
				break;
			}
		}		
		for (int k = 0; k < 20 ; i++ , k++) {
			CopyArray(a[i-20],Log20[k]);
		}
		return Log20;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~~~~~~ COPY ARRAY FROM ONE TO ANOTHER ~~~~~~~~~~~~~//
	public static void CopyArray (int copy[],int paste[]){
		for (int i = 0; i < copy.length; i++) {
			paste[i] = copy[i];
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~~~~~~~~~~~~~~~ TAKES ARRAY AND PROCCESS TO AN ARRAY ~~~~~~~~~~~~~~~~~~//
	//~~~~~ Done[0] = zero found inside the array , Done[1] = Cold Level , Done[2] = Hot Level ~~~~~~~//
	public static int[] Array1DStatisticProccessing (int a[]) {
		int zeroflag = 0;
		int heat = 0;
		int cold = 0;
		int LowerCritical = 18;
		int HigherCritical = 63;
		int highFlag = 0;
		int lowerFlag = 0;
		for (int i = 0; i < a.length; i++) {if (a[i] == 0) {zeroflag = 1;}}
		if (zeroflag == 0) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] > HigherCritical) {heat++;}else {heat = 0;}
				if (heat>2) {highFlag++;}
				if (a[i] < LowerCritical) {cold++;}else {cold = 0;}
				if (cold>2) {lowerFlag++;}
			}
		}
		int Done [] = new int [3];
		Done[0] = zeroflag;
		Done[1] = lowerFlag;
		Done[2] = highFlag;
		return Done;	
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	//~~~~~~~~~~ Returns the place of Largest number among 3 ~~~~~~~~~//
	public static int LargestOutof3 (int a, int b, int c) {
		if( a >= b && a >= c) {
			return 1;
		}
		else if (b >= a && b >= c) {
			return 2;
		}
		else {
			return 3;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	
	
	//~~~~~~~~~~ Returns the place of smallest number among 3 ~~~~~~~~~//
	public static int SmallestOutof3 (int a, int b, int c) {
		if ((a+b+c)!=0) {
			if( a <= b && a <= c) {
				return 1;
			}
			else if (b <= a && b <= c) {
				return 2;
			}
			else {
				return 3;
			}
		}else {
			return 0;
		}
		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	
	

	public static void main(String[] args) {

		int test [] = {1,2,3,4,5,6,7,56,67,78,89,87,76,65,54,43,23,34,45,65};


		Array1DStatisticProccessing(test);


	}



	//###################  DEMO ########################//
	/*public static void main(String[] args) {
		int test2[][] = new int [23][13];
		for (int i = 0; i < test2.length; i++) {
			for (int j = 0; j < test2[0].length; j++) {
				test2[i][j] = ((int)(Math.random()*3)+1);
			}
		}
		System.out.println("Test: "+Arrays.toString(Col2Row(test2,3,10,22)));
		int extract [] = Col2Row(test2,12,10,22);
		System.out.println(Arrays.toString(AppearanceCounter(extract)[0]));
		System.out.println(Arrays.toString(AppearanceCounter(extract)[1]));
	}*/
	//###################################################//
}
