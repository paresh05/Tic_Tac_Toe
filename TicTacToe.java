package com.bridgelabzworkshop;

import java.util.Scanner;

public class TicTacToe {
	
	public static char board[]=new char[10]; //@param board[] is an array of characters used as a board to play the game 
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
		char letter=sc.next().charAt(0);
	}

	public static void main(String[] args) {
			//Function call
			createBoard();
			userInput();
	}

}