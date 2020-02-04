import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
	C4HumanPlayer(char playerPiece){
		super(playerPiece);
	}

	@Override
	int chooseMove() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a column to play(or 'quit'): ");
		if(in.hasNext("quit")) {
			return -1;
		}
		return in.nextInt()-1;
	}
	
}
