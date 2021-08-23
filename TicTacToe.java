package com.bridgelabzworkshop;

public class TicTacToe {
	//function of user case 1
	public static void uc1()
	{

		System.out.println("Welcome to the Tic Tac Toe Game");
		char board[][];
		board=new char[3][3]; 
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]=' ';
			}
		}
	}

	public static void main(String[] args) {

			uc1();
	}

}
