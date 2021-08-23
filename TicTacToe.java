package com.bridgelabzworkshop;

public class TicTacToe {
	
	public static void uc1()
	{

		System.out.println("Welcome to the Tic Tac Toe Game");
		char arr[][];
		arr=new char[3][3];
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				arr[i][j]=0;
			}
		}
	}

	public static void main(String[] args) {

			uc1();
	}

}
