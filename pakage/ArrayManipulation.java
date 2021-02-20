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
