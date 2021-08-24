package com.bridgelabzworkshop;

import java.util.Scanner;

public class TicTacToe {
	
	public static char board[]=new char[10]; //@param board[] is an array of characters used as a board to play the game
	public static char userLetter; //@param userLetter is of type character used for user in the game
	public static char computerLetter; //@param computerLetter is of type character used for computer in the game
	/* Function of createBoard 
	 * This function creates a board using for loop
	 * The elements of array board are initialized to empty space */
	public static void createBoard()
	{
		System.out.println("Welcome to the Tic Tac Toe Game");
		for(int i=1;i<board.length;i++)
		{
				board[i]=' ';
		}
	}
	/* Function of user input
	 * This function takes the input from user 
	 * It allows player to choose a letter X or O */
	public static void userInput()
	{
		System.out.println("Choose the letter X or O");
		Scanner sc = new Scanner(System.in);
		userLetter=sc.next().charAt(0);
		if(userLetter=='O')
			computerLetter='X';
		else
			computerLetter='O';
	}
	//This function displays the board 
	public static void showBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[1] + " | "+ board[2] + " | " + board[3]+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | "+ board[5] + " | " + board[6]+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | "+ board[8] + " | " + board[9]+ " |");
		System.out.println("|---|---|---|");
	}
	/* Function makeMove
	 * This function allows the user to make a move to a desired location in the board by taking input from the user*/
	public static void makeMove()
	{
		int madeaMove=0;
		System.out.println("Make a move");
		System.out.println("Select any index between 1 to 9 to make a move");
		Scanner sc = new Scanner(System.in);
		while(madeaMove==0) {
			int position=sc.nextInt();
			if(board[position]==' ') {
				board[position]=userLetter;
				madeaMove=1;
			}
			else {
				System.out.println("Not a freespace. Make a different move");
			}
		}
	}
	/* Function computerMakeMove
	 * This function allows the computer make move */
	public static void computerMakeMove()
	{
		int index = ((int) Math.floor(Math.random()*10) % 9)+1;
		board[index]=computerLetter;
	}
	/* Function toss
	 * This function is used to determine Heads or Tails and assign accordingly who starts first, the computer or the user*/
	public static void toss()
	{
		int userToss;
		System.out.println("Enter 1 or 0 to check who plays first");
		Scanner sc = new Scanner(System.in);
		userToss=sc.nextInt();

		int randomToss = (int) Math.floor(Math.random()*10) % 2;
		
		if(userToss==randomToss) {
			System.out.println("You Play First");
			makeMove();
			}
		else {
			System.out.println("Computer plays first");
			computerMakeMove();
		}
		showBoard();
	}
	public static void main(String[] args) {
			//Function call
			createBoard();
			userInput();
			showBoard();
			toss();
			
	}

}