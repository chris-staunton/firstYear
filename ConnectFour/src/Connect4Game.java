
/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: My class creates references to the grid and 2 players. then it loops asking if user wants to play. if they enter play, the grid is created and the players are innitialised, then the game starts. The game is inside a loop which asks the user for a column to place their piece, then checks if winning move, then the computer plays and checks if that is a winning move. all moves are checked to be valid.

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: all 7 methods are defined in the interface

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: my class implements all of the interface. it creates a 2D array, and implements the emptyGrid(), checkwinner, etc...

ConnectPlayer abstract class (10 marks)
My class provides at least one non-abstract method and at least one abstract method. 
Comment: my ConnectPlayer provides one non-abstract method (getPiece) and one abstract method(chooseMove)

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: My class extends the ConnectPlayer class and overrides the abstract method. It asks the user for input

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment: My class extends the ConnectPlayer claas and overrides the abstract method. It randomly generates a number between 1 and 7

Total Marks out of 100: 100

*/
import java.util.Scanner;
public class Connect4Game {
	public static void main(String[] args) {
		boolean gameOn = true;
		Scanner input = new Scanner(System.in);
		while(gameOn) {
			System.out.println("Would you like to play or quit?");
			String choice = input.nextLine();
			if(choice.equals("play")) {
				Connect4Grid board = new Connect4Grid2DArray();
				C4HumanPlayer human = new C4HumanPlayer('R');
				C4RandomAIPlayer computer = new C4RandomAIPlayer('Y');
				board.emptyGrid();	
				while(!board.isGridFull()&&!board.didLastPieceConnect4()&&gameOn) {
					System.out.println(board.toString());
					int column = human.chooseMove();
					if(column==-1) {
						gameOn=false;
					}
					if(!board.didLastPieceConnect4()){
						int computerColumn = computer.chooseMove();
					
						if(board.isValidColumn(column)&&board.isValidColumn(computerColumn)) {
							board.dropPiece(human, column);
							if(!board.didLastPieceConnect4()) {
								board.dropPiece(computer, computerColumn);
							}
							else {
								System.out.println("Human Player is the Winner!!!");
							}
						}
					}
					else {
						System.out.println("Computer Player is the Winner!!!");
					}
				}
				System.out.println(board.toString());
				System.out.println("GAME OVER");
			}
			else if(choice.equals("quit")) {
				gameOn =false;
			}
			else {
				System.out.println("Invalid input, please enter 'play' or 'quit'.");
			}
		}
		System.out.println("GOODBYE!!!");	
	}	
}
