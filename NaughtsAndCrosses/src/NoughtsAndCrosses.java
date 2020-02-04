/* SELF ASSESSMENT  
   1.  clearBoard:
Did I use the correct method definition?
Mark out of 5: 5
Comment: i used the correct method definition
Did I use loops to set each position to the BLANK character?
Mark out of 5: 5
Comment: i sed for loops to clear every location
   2.  printBoard
Did I use the correct method definition?
Mark out of 5: 5
Comment:i used the correct method definition
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5: 5
Comment: i printed out the board with --- and | to create the appearance of a board
   3.  canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5 
Comment: i used the correct function definition and returned a boolean.
Did I check if a specified location was BLANK?
Mark out of 5: 5
Comment: i checked if the specified location was blank. if blank return true
   4.  makeMove
Did I have the correct function definition?
Mark out of 5: 5
Comment:i used the correct function definition
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5: 5
Comment:    the current player piece is set in specified location. the player piece is changed every time a successful move is made.
   5.  isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment:        i used the correct function definition and returned a boolean.
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5: 5
Comment: yes, if i found one blank character, it returns false.
   6.  winner
Did I have the correct function definition and returned the winning character
Mark out of 5: 5
Comment:     i used the correct function definition and returned the winning character
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15: 15
Comment: all possible winning combinations accounted for. In total 8 possible winning moves
   7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3: 3
Comments: created board of size 3x3 and cleared it.
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5: 5
Comments: if full will clear and restart, if winner will print winner, else it will ask for another location
Did I call all of the methods above?
Mark out of 5: 5
Comments: all methods are called
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3: 3
Comments: handled with if statements
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3: 3
Comments: yes, used *-1 and a switch statement to change pieces after every valid move.
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3: 3
Comments: displayed winner but if draw said draw and cleared the board.

   8.  Overall
Is my code indented correctly?
Mark out of 3: 3
Comments: my code is indented properly
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3: 3
Comments: all variable and constant name make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2: 2
Comments: yes they follow standard
      Total Mark out of 100 (Add all the previous marks):  
*/
import java.util.Scanner;

public class NoughtsAndCrosses {
	public static final int NUMBER_OF_ROWS_AND_COLUMNS = 3;
	public static final char CROSS_PLAYER_PIECE = 'X';
	public static final char NOUGHT_PLAYER_PIECE = 'O';
	public static final char BLANK_CHARACTER = ' ';
	
	public static void clearBoard(char[][] board) {
		for (int rowIndex = 0; rowIndex < NUMBER_OF_ROWS_AND_COLUMNS; rowIndex++) {
			for (int columnIndex =0; columnIndex < NUMBER_OF_ROWS_AND_COLUMNS; columnIndex++) {
				board[rowIndex][columnIndex] = BLANK_CHARACTER;
			}
		}	
	}
	public static void printBoard(char[][] board) {
		String boardString = "";
		for (int rowIndex = 0; rowIndex < NUMBER_OF_ROWS_AND_COLUMNS; rowIndex++) {
			for (int columnIndex =0; columnIndex < NUMBER_OF_ROWS_AND_COLUMNS; columnIndex++) {
				boardString += " " + board[rowIndex][columnIndex] + " ";
				boardString += (columnIndex < 2 ? " | " : "");
			}
			boardString += "\n";
			boardString += (rowIndex < 2 ? "----------------\n" : "");
		}
		System.out.println(boardString);
	}
	public static boolean canMakeMove(char[][] board, int row, int column) {
		if(board[row][column] == BLANK_CHARACTER) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void makeMove(char[][] board, char currentPlayerPiece , int row, int column) {
		if (canMakeMove(board, row, column)) {
			board[row][column] = currentPlayerPiece;
		}
		else {
			System.out.println("Error, Move not permitted.");
		}
	}
	public static boolean isBoardFull(char[][] board) {
		boolean fullBoard = true;
		for (int rowIndex = 0; rowIndex < NUMBER_OF_ROWS_AND_COLUMNS; rowIndex++) {
			for (int columnIndex =0; columnIndex < NUMBER_OF_ROWS_AND_COLUMNS; columnIndex++) {
				if(board[rowIndex][columnIndex] == BLANK_CHARACTER) {
					fullBoard = false;
				}
			}
		}
		return fullBoard;
	}
	public static char winner(char[][] board) {
		if((board[0][0] == board[0][1])&&(board[0][0] == board[0][2])
			||(board[0][0] == board[1][0])&&(board[0][0] == board[2][0]))
		{
			return board[0][0];
		}
		else if ((board[0][0] == board[1][1])&&(board[0][0] == board[2][2])
			||(board[0][2] == board[1][1])&&(board[0][2] == board[2][0])
			||(board[1][0] == board[1][1])&&(board[1][0] == board[1][2])
			||(board[0][1] == board[1][1])&&(board[0][1] == board[2][1]))
		{
			return board[1][1];
		}
		else if ((board[2][0] == board[2][1])&&(board[2][0] == board[2][2])
			||(board[0][2] == board[1][2])&&(board[0][2] == board[2][2]))
		{
			return board[2][2];
		}
		else 
		{
			return BLANK_CHARACTER;
		}
	}
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		char[][] board = new char[NUMBER_OF_ROWS_AND_COLUMNS][NUMBER_OF_ROWS_AND_COLUMNS];
		boolean finished = false;
		int playerPieceMultiplier = -1;
		char currentPlayerPiece = CROSS_PLAYER_PIECE;
		clearBoard(board);
		while(!finished)
		{
			printBoard(board);
			System.out.println("Enter position on board(row column): ");
			if (inputScanner.hasNextInt()) {
				
				int row = inputScanner.nextInt();
				int column = inputScanner.nextInt();
				if (row > 2 || column > 2 || row < 0 || column < 0) {
					System.out.println("Error, please enter valid location.");
				}
				else if (isBoardFull(board)==true) {
					finished = true;
					winner(board);
				}
				else if (canMakeMove(board, row, column)) {
					switch (playerPieceMultiplier)
					{
					case -1:
						currentPlayerPiece = CROSS_PLAYER_PIECE;
						break;
					case 1:
						currentPlayerPiece = NOUGHT_PLAYER_PIECE;
						break;
					}
					makeMove(board, currentPlayerPiece, row, column);
					playerPieceMultiplier *= -1;
					
				}
				else {
					System.out.println("Location already occupied, please select different location.");
				}
			}
			else {
				System.out.println("Error, Please enter valid input.");
				inputScanner.next();
			}
			if(winner(board) == CROSS_PLAYER_PIECE || winner(board) == NOUGHT_PLAYER_PIECE) {
				printBoard(board);
				System.out.println("the winner is " + winner(board));
				finished = true;
				inputScanner.close();
			}
			else if (isBoardFull(board)) {
				printBoard(board);
				System.out.println("Draw. Start again.");
				clearBoard(board);
			}
		}
		
		
 	}
}
