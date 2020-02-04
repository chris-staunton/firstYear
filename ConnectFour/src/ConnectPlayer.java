
public abstract class ConnectPlayer {
	protected char playerPiece;

	ConnectPlayer(char piece) {
		this.playerPiece = piece;
	}
	abstract int chooseMove();
	char getPiece() {
		return this.playerPiece;
	}
	
}
