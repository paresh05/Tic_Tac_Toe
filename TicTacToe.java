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
	public static void main(String[] args) {
			//Function call
			createBoard();
			showBoard();
			userInput();
			
	}

}