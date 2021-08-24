package com.bridgelabzworkshop;

import java.util.Scanner;

public class TicTacToe {

	public static char board[]=new char[10];  //@param board[] is an array of characters used as a board to play the game 
	public static char userLetter;  //@param userLetter is of type character used for user in the game
	public static char computerLetter;  //@param computerLetter is of type character used for computer in the game
	public static int userToss;  //@param userToss is used for users preference for toss in the game
	public static int randomToss;  //@param randomToss is used for toss to check who plays first in the game
	
	/* Function of createBoard 
	 * This function creates a board using for loop
	 * The elements of array board are initialized to empty space */
	public static void createBoard()
	{
		for(int index=1;index<board.length;index++)
		{
				board[index]=' ';
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
		int madeaMove=0;
		int index1=0;
		while(madeaMove==0) {
			index1 = ((int) Math.floor(Math.random()*10) % 9)+1;
			
				for(int i=1;i<9;i++)
				{
					if(((i%3)!=0)&&(board[i]==board[i+1])&&(board[i]==userLetter))
					{
						if((i==1||i==4||i==7)&&(board[i+2]==' ')) {
							index1=(i+2);
							break;
						}
						else if((i==2||i==5||i==8)&&board[i-1]==' ')
						{
							index1=(i-1);
							break;
						}
					}
					else if(((i+3)<board.length)&&(board[i]==board[i+3])&&(board[i]==userLetter))
					{
						if((i==1||i==2||i==3)&&(board[i+6]==' ')) {
							index1=i+6;
							break;
						}
						else if((i==4||i==5||i==6)&&(board[i-3]==' ')) {
							index1=i-3;
							break;
						}
					}
					else if((board[1]==board[5])&&(board[9]==' ')&&(board[1]==userLetter))
					{
						index1=9;
						break;
					}
					else if((board[3]==board[5])&&(board[7]==' ')&&(board[3]==userLetter))
					{
						index1=7;
						break;
					}
					else if((board[9]==board[5])&&(board[1]==' ')&&(board[5]==userLetter))
					{
						index1=1;
						break;
					}
					else if((board[7]==board[5])&&(board[3]==' ')&&(board[5]==userLetter))
					{
						index1=3;
						break;
					}
					else if(((i+6)<board.length)&&(board[i]==board[i+6])&& board[i+3]==' '&&(board[i]==userLetter))
					{
						index1=i+3;
						break;
					}
					else if(((i+2)<board.length)&&(board[i]==board[i+2])&& board[i+1]==' '&&(board[i]==userLetter))
					{
						index1=i+1;
						break;
					}
					else if((board[1]==board[9])&&(board[5]==' ')&&(board[3]==userLetter))
					{
						index1=5;
						break;
					}
					else if((board[3]==board[7])&&(board[5]==' ')&&(board[3]==userLetter))
					{
						index1=5;
						break;
					}
				}
			

				if(board[index1]==' ') {
					board[index1]=computerLetter;
					madeaMove=1;
				}
		}
	}
	/* Function toss
	 * This function is used to determine Heads or Tails and assign accordingly who starts first, the computer or the user*/
	public static void toss()
	{
		System.out.println("Enter 1 or 0 to check who plays first");
		Scanner sc = new Scanner(System.in);
		userToss=sc.nextInt();

		randomToss = (int) Math.floor(Math.random()*10) % 2;
		
		if(userToss==randomToss) {
			System.out.println("You Play First");
			makeMove();
			}
		else {
			System.out.println("Computer plays first");
			computerMakeMove();
		}
		showBoard();
		System.out.println();
	}
	/* Function play
	 * This function executes until anyone wins or the board is full */
	public static void play()
	{
		int winner=0;
		int isFull=0;
		if(userToss==randomToss) {
			for(int index=2;index<10;index++) {
				computerMakeMove();
				winner=checkWinner();
				showBoard();
				System.out.println();
				if(winner==0)
					isFull=isBoardFull();
				if(winner==1||isFull==1)
					break;
				makeMove();
				winner=checkWinner();
				showBoard();
				System.out.println();
				if(winner==0)
					isFull=isBoardFull();
				if(winner==1||isFull==1)
					break;	
			}
		}
		else {
			for(int index=2;index<10;index++) {
				makeMove();
				winner=checkWinner();
				showBoard();
				System.out.println();
				if(winner==0)
					isFull=isBoardFull();
				if(winner==1||isFull==1)
					break;
				computerMakeMove();
				winner=checkWinner();
				showBoard();
				System.out.println();
				if(winner==0)
					isFull=isBoardFull();
				if(winner==1||isFull==1)
					break;
			}
		}
	}
	// This function checks the winner 
	public static int checkWinner()
	{
		char letter=' ';
		if((board[1]==board[2])&&(board[3]==board[1])&&(board[1]!=' ')&&(board[2]!=' ')&&(board[3]!=' ')) {
			 {
				letter=board[1];	
			}
		}
		else if((board[4] == board[5])&&(board[6]==board[4])&&(board[4]!=' ')&&(board[5]!=' ')&&(board[6]!=' ')) {
				letter=board[4];	
		}	
		else if((board[7] == board[8])&&(board[9]==board[7])&&(board[7]!=' ')&&(board[8]!=' ')&&(board[9]!=' ')) {
				letter=board[7];	
		}	
		else if((board[1] == board[4])&&(board[7]==board[1])&&(board[1]!=' ')&&(board[4]!=' ')&&(board[7]!=' ')) {
			
				letter=board[1];	
		}
			
		else if((board[2] == board[5])&&(board[8]==board[2])&&(board[2]!=' ')&&(board[5]!=' ')&&(board[8]!=' ')) {
				letter=board[2];
		}
			
		else if((board[3] == board[6])&&(board[9]==board[3])&&(board[3]!=' ')&&(board[6]!=' ')&&(board[9]!=' ')) {
				letter=board[3];	
		}	
		else if((board[1] == board[5])&&(board[9]==board[1])&&(board[1]!=' ')&&(board[5]!=' ')&&(board[9]!=' ')) {	
				letter=board[1];	
		}	
		else if((board[3] == board[5])&&(board[7]==board[3])&&(board[3]!=' ')&&(board[5]!=' ')&&(board[7]!=' ')) {	
				letter=board[7];		
		}
		if(letter==userLetter)
		{
			System.out.println(" You are the winner ");
			return 1;
		}
		else if(letter==computerLetter)
		{
			System.out.println("Computer is the winner");
			return 1;
		}
		else {
			return 0;
			}	
	}
	// This function checks if the board is full or not
	public static int isBoardFull()
	{   
		int isFull=1;
		for(int index=0;index<board.length;index++) {
			if(board[index]==' ') {
				isFull=0;
			}
		}
		if(isFull==1) {
			System.out.println("Its a Draw");
			return 1;
			}
		else return 0;
	}
	public static void main(String[] args) {
		
			System.out.println("Welcome to the Tic Tac Toe Game");
			
			createBoard(); //Function call to createBoard function
			userInput();   //Function call to userInput function
			showBoard();   //Function call to showBoard function
			toss();        //Function call to toss function
			play();	       //Function call to play function
	}
}