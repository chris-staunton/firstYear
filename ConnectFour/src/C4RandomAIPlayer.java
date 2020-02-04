import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer {
	
	C4RandomAIPlayer(char piece){
		super(piece);
	}
	@Override
	int chooseMove() {
		Random rand = new Random();
		int random = rand.nextInt(7);
		System.out.println("The computer played at column: " + (random+1));
		return random;
	}
}
