import java.util.ArrayList;
import java.util.Random; //imports the Random Class
import java.util.Scanner; //imports the Scanner Class
/***************************************************************************************
*   Name: Justin Baltazar
*   Program: Minesweeper
*   Date: 4/25/18
*
***************************************************************************************/
/***************************************************************************************
*    Citation:
*    Title: Java – Convert String to int
*    Author: mkyong
*    Date: July 1, 2015
*    Type: Source Code (Tutorial)
*    Code version: v1.0
*    Availability: https://www.mkyong.com/java/java-convert-string-to-int/
*
***************************************************************************************/
public class Minesweeper {

	public static void main(String[] args){
        
		Scanner sc = new Scanner(System.in); //Instantiates the Scanner class named sc into the main method.
		Random rand = new Random(); //Instantiates the Random class named rand into the main method.
		
		int isFalse = 0; //Declares an int named isFalse and sets it equal to 0.
		int isTrue = 0; //Declares an int named isTrue and sets it equal to 0.
		int locale = 1; //Declares an int named locale and sets it equal to 1.
		int nX = 9; //Declares an int named nX and sets it equal to 9.
		int nY = 9; //Declares an int named nY and sets it equal to 9.
		int toVictory = 0; //Declares an int named toVictory and sets it equal to 0.
		int arr2length = 10; //Declares an int named arr2length and sets it equal to 10.
		int boardSize = 81; //Declares an int named boardSize and sets it equal to 81.
		
		String userinput = ""; //Declares a String named userinput and names it an empty string.
		String randMineSet = (rand.nextInt(boardSize) + 1) + ""; //Declares a string named userinput and generates
																 //a random number from 1 to boardSize, inclusive.	
		
		System.out.println("Minesweeper! Copyright © 2018 Justin Baltazar. All rights reserved.");
		System.out.println("Select your difficulty!");
		System.out.println("1): Beginner (9 x 9)");
		System.out.println("2): Intermediate (16 x 16)");
		System.out.println("3): Hard (16 x 30) \n");
		System.out.print("Enter either 1, 2, or 3 to begin the game: ");
		
		int difficultySelection = sc.nextInt(); //Declares an int named difficultySelection and sets it equal to the user's next input. 
		
		if(difficultySelection == 1){ //Executes the bracketed code provided the user inputs '1' as the value for difficultySelection.
			//
			//No action is taken in this selection, as the values for "Beginner" are 
			//already declared alongside the instantiation of the variables.
		}
		else if(difficultySelection == 2){ //Executes the bracketed code provided the user inputs '2' as the value for difficultySelection.
			nX = 16; //Sets the rows of the board to 16.
			nY = 16; //Sets the columns of the board to 16.
			arr2length = 40; //Sets the amount of mines to produce to 40.
			boardSize = (nX * nY); //Sets boardSize equal to the product of variables nX and nY.
		}
		else if(difficultySelection == 3){ //Executes the bracketed code provided the user inputs '3' as the value for difficultySelection.
			nX = 16; //Sets the rows of the board to 16.
			nY = 30; //Sets the columns of the board to 30.
			arr2length = 99; //Sets the amount of mines to produce to 99.
			boardSize = (nX * nY); //Sets boardSize equal to the product of variables nX and nY.
		}
		else{ //Executes the bracketed code provided the value for difficultySelection does not satisfy any of the prior statements.
			System.out.println("Program Terminated."); 
			System.exit(-1); //Terminates the program.
		}
		
		String [] arr2 = new String[arr2length]; //Declares an array of Strings named arr2 and sets the number of indexes to the value of the int arr2length.
		String[][] arr = new String[nX][nY]; //Declares a 2D array of Strings named arr and sets the number of indexes to the values of nX and nY

		for(int i = 0; i < nX; i++)
		{
			for(int j = 0 ; j < nY; j++) // For each index in the 2D array named arr, as along as the rows
			{							 // and columns are less than their respective values of nX and nY,
				arr[i][j] = locale + ""; // assign each String to a typecasted number in ascending order.
				locale++;				 
			}
		}	
		
		System.out.println("\n");
		System.out.println("Welcome to the game of MineSweeper! Here's your board. Avoid guessing the mines to win!");
		
		mineSet(arr2, randMineSet, boardSize, arr2length); // Calls the method named mineSet with the parameters arr2, randMineSet, boardSize, and arr2length.
		
//		for(int v = 0; v < arr2length; v++)
//		{
//			System.out.print("Mine: " + arr2[v] + "\n"); // This for loop is used to print out the location of each mine for debugging.
//											  			 // To test if the code works, uncomment lines 71-75 to print out mines.
//		}	
		
		printBoard(arr, nX, nY); //Calls the method named printBoard with the parameters arr, nX, and nY.
		
		prompt(arr, arr2, userinput, toVictory, isFalse, isTrue, args, boardSize, nX, nY, arr2length, difficultySelection); //Calls the method named prompt with the following parameters.
			
	}
	private static void printBoard(String[][] arr, int nX, int nY){ //Creates a static method with no return type named printBoard with the following parameters.
		System.out.println("");
		for(int t = 0; t < nX; t++)
		{
		    for(int u = 0; u < nY; u++)				// This for loop will print out the contents of the 2D array named
		    {										// arr in a readable fashion each time this method is called with
		        System.out.print(arr[t][u] + "\t"); // its appropriate parameters.
		    }
		    System.out.println();
		}
	}
	private static void prompt(String[][] arr, String[] arr2, String userinput, int toVictory, int isFalse, int isTrue, String[] args, int boardSize, int nX, int nY, int arr2length, int difficultySelection){
				
		int mineSurround = 0;
		int counter = 0;
		
		ArrayList<String> arr3 = new ArrayList<String>();
		ArrayList<String> arr4 = new ArrayList<String>();
		
		Scanner sc =  new Scanner(System.in);
		
		if(toVictory < (boardSize - arr2.length)){
			
			System.out.println("");
			System.out.println("Bonus: To place a flag on a spot, type in the desired number followed by the letter F.");
			System.out.println("       To unflag a random spot, type in the number of a flagged spot followed by the letter F.");
			System.out.print("Guess a spot on the board (Type a number between 1 and " + (nX * nY) + "): ");
						
			userinput = sc.next();
	
			for(int p = 0; p < arr2.length; p++){
				if(!userinput.equals(arr2[p])){
					isFalse++;
				}
			}

			for(int a = 0; a < arr.length; a++)
			{
			    for(int b = 0; b < arr[0].length; b++)
			    {
			    	if(userinput.equals(arr[a][b]) && isFalse != arr2length){
			    		arr[a][b] = "X";
			    		mineHit(arr, nX, nY);
			    	}
			    	else if(userinput.equals(arr[a][b]) && isFalse == arr2length){
			    		toVictory++;
			    		
			    		if(difficultySelection == 1){
			    			for(int o = 0; o < arr2.length; o++){
			    				
			    				String num = arr[a][b];
			    				int res = Integer.parseInt(num);			
			    				
			    				if((res-6) <= 2 && res != 1){
			    					if(arr[a+1][b].equals(arr2[o]) || arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 1){
			    					if(arr[a][b+1].equals(arr2[o]) || arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 9){
			    					if(arr[a+1][b].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 73){
			    					if(arr[a-1][b].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a][b+1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 81){
			    					if(arr[a-1][b].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res % 9 == 1){
			    					if(arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res % 9 == 0){
			    					if(arr[a+1][b-1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if((res-6) <= 74 && res != 81){
			    					if(arr[a-1][b-1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) 
					    		|| arr[a+1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    				}
			    			}
			    		}
			    		else if(difficultySelection == 2){
			    				for(int o = 0; o < arr2.length; o++){
			    				
			    				String num = arr[a][b];
			    				int res = Integer.parseInt(num);			
			    				
			    				if((res-13) <= 2 && res != 1){
			    					if(arr[a+1][b].equals(arr2[o]) || arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 1){
			    					if(arr[a][b+1].equals(arr2[o]) || arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 16){
			    					if(arr[a+1][b].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 241){
			    					if(arr[a-1][b].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a][b+1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 256){
			    					if(arr[a-1][b].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res % 16 == 1){
			    					if(arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res % 16 == 0){
			    					if(arr[a+1][b-1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if((res-13) <= 241 && res != 256){
			    					if(arr[a-1][b-1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) 
					    		|| arr[a+1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    				}
			    			}
			    		}
			    		else if(difficultySelection == 3){
			    				for(int o = 0; o < arr2.length; o++){
			    				
			    				String num = arr[a][b];
			    				//System.out.println(arr[a][b]);
			    				int res = Integer.parseInt(num);			
			    				//System.out.println(res);		
			    				
			    				if((res-27) <= 2 && res != 1){
				    					if(arr[a+1][b].equals(arr2[o]) || arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
				    						mineSurround++;
				    					}
			    				}
			    				else if(res == 1){
			    					if(arr[a][b+1].equals(arr2[o]) || arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 30){
			    					if(arr[a+1][b].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 451){
			    					if(arr[a-1][b].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a][b+1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res == 480){
			    					if(arr[a-1][b].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res % 30 == 1){
			    					if(arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(res % 30 == 0){
			    					if(arr[a+1][b-1].equals(arr2[o]) || arr[a+1][b].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if((res-27) <= 452 && res != 480){
			    					if(arr[a-1][b-1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    					}
			    				}
			    				else if(arr[a+1][b+1].equals(arr2[o]) || arr[a+1][b-1].equals(arr2[o]) || arr[a-1][b+1].equals(arr2[o]) || arr[a-1][b-1].equals(arr2[o]) 
					    		|| arr[a+1][b].equals(arr2[o]) || arr[a][b+1].equals(arr2[o]) || arr[a-1][b].equals(arr2[o]) || arr[a][b-1].equals(arr2[o])){
			    						mineSurround++;
			    				}
			    			}
			    		}
			    		
			    		arr[a][b] = "[" + mineSurround + "]";
			    		isFalse = 0;
			    		mineMiss(toVictory, isFalse, userinput, arr, arr2, nX, nY);
			    		prompt(arr, arr2, userinput, toVictory, isFalse, isTrue, args, boardSize, nX, nY, arr2length, difficultySelection);
			    	}
			    	else if(userinput.equals(arr[a][b] + "F") && !arr3.contains(userinput)){
			    		
			    		arr3.add(userinput);
			    		arr4.add(arr[a][b]);
			    		
			    		arr[a][b] = "!";
			    		counter++;
			    		printBoard(arr, nX, nY);
			    		prompt(arr, arr2, userinput, toVictory, isFalse, isTrue, args, boardSize, nX, nY, arr2length, difficultySelection);
			    	}
			    	else if(arr3.contains(userinput)){
			    		
			    		String res2 = arr[a][b];
	    				int num2 = Integer.parseInt(res2);			
	    				
	    				num2 = (num2 - 1);
	    					    				
	    				if(num2 == 9 && difficultySelection == 1){
	    					arr[0][8] = num2 + "";
	    				}
	    				else if(num2 == 16 && difficultySelection == 2){
	    					arr[0][15] = num2 + "";
	    				}
	    				else if(num2 == 30 && difficultySelection == 3){
	    					arr[0][29] = num2 + "";
	    				}
	    				else{
	    					arr[a][b-1] = num2 + "";  
	    				}
	    				res2 = "";
			    		printBoard(arr, nX, nY);
			    		prompt(arr, arr2, userinput, toVictory, isFalse, isTrue, args, boardSize, nX, nY, arr2length, difficultySelection);
			    	}
			   }
			}
		}
		else{
			System.out.println(toVictory);
    		winner(arr, args, nX, nY);
		}
	}
	private static void mineHit(String[][] arr, int nX, int nY){
		System.out.println("");	
		printBoard(arr, nX, nY);
		System.out.println("------------------------------------------------------");
		System.out.println(" Sorry, but you unfortunately hit a mine! Game Over!  ");
		System.out.println("------------------------------------------------------");
		System.exit(-1);
	}
	private static void mineMiss(int toVictory, int isFalse, String userinput, String[][] arr, String[] arr2, int nX, int nY){
		printBoard(arr, nX, nY);
		//isFalse = 0;
	}
	private static void winner(String[][] arr, String[] args, int nX, int nY){
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------------------------");
		System.out.println(" Congradulations, you avoided all the mines! You Win! ");
		System.out.println("          Thank you for playing Minesweeper!          ");
		System.out.println("------------------------------------------------------");
		printBoard(arr, nX, nY);
		System.out.print("\n Would you like to play again? (Y/N): ");
		char userSelection = sc.next().charAt(0);
		if(userSelection == 'Y'){
			Minesweeper.main(args);
		}
		else{
			System.out.println("Goodbye!");
			System.exit(-1);
		}
	}
	private static void mineSet(String[] arr2, String randMineSet, int boardSize, int arr2length){
		Random rand = new Random();
		for(int e = 0; e < arr2length; e++)
		{
			arr2[e] = randMineSet + "";
			randMineSet = (rand.nextInt(boardSize) + 1) + "";
			
		}
		for (int i = 0; i < arr2length; i++) { 
			for (int j = i + 1 ; j < arr2length; j++) { 
				if (arr2[i].equals(arr2[j])){  
					arr2[j] = (rand.nextInt(boardSize) + 1) + "";
				}
			}
		}	
	}
}
