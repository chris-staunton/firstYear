
public class Connect4Grid2DArray implements Connect4Grid{
	final int NO_OF_ROWS = 6;
	final int NO_OF_COLS = 7;
	private char[][] board;
	public Connect4Grid2DArray(){
		
		board = new char[NO_OF_ROWS][NO_OF_COLS];
	}
	public void emptyGrid() {
				
		for(int i=0; i<NO_OF_ROWS; i++) {
			for(int j=0; j<NO_OF_COLS; j++) {
				this.board[i][j] = 'O';
			}
		}
	}
	public String toString() {
		String boardString = "  1 2 3 4 5 6 7\n";
		for(int i=0; i<NO_OF_ROWS; i++) {
			boardString += i+1 + " ";
			for(int j=0; j<NO_OF_COLS; j++) {
				boardString+= board[i][j] + " ";
			}
			boardString+= "\n";
		}
		return boardString;
	}
	public boolean isValidColumn(int column) {
		if(column<7&&column>=0&&!isColumnFull(column)) {
			return true;
		}
		return false;
	}
	public boolean isColumnFull(int column) {
		if(board[0][column]!='O') {
			return true;
		}
		return false;
	}
	public void dropPiece(ConnectPlayer player, int column) {
		char playerPiece = player.getPiece();
		if(isValidColumn(column)) {
			if(board[NO_OF_ROWS-1][column]=='O') {
				board[NO_OF_ROWS-1][column] = playerPiece;
			}
			else if(board[NO_OF_ROWS-2][column]=='O') {
				board[NO_OF_ROWS-2][column] = playerPiece;
			}
			else if(board[NO_OF_ROWS-3][column]=='O') {
				board[NO_OF_ROWS-3][column] = playerPiece;
			}
			else if(board[NO_OF_ROWS-4][column]=='O') {
				board[NO_OF_ROWS-4][column] = playerPiece;
			}
			else if(board[NO_OF_ROWS-5][column]=='O') {
				board[NO_OF_ROWS-5][column] = playerPiece;
			}
			else if(board[NO_OF_ROWS-6][column]=='O') {
				board[NO_OF_ROWS-6][column] = playerPiece;
			}
			
		}
		
		
	}
	public boolean didLastPieceConnect4() {
		//horizontal
		for(int i =0; i<NO_OF_ROWS; i++) {
			for(int j=0; j<NO_OF_COLS-3; j++) {
				if(board[i][j]!='O' && board[i][j]==board[i][j+1] &&
						board[i][j+1]==board[i][j+2] && board[i][j+2]==board[i][j+3]) {
					return true;
				}
			}
			
		}
		//vertical
		for(int i =0; i<NO_OF_ROWS-3; i++) {
			for(int j=0; j<NO_OF_COLS; j++) {
				if(board[i][j]!='O' && board[i][j]==board[i+1][j] &&
						board[i+1][j]==board[i+2][j] && board[i+2][j]==board[i+3][j]) {
					return true;
				}
			}
			
		}
		//diagonal
		for(int i =0; i<NO_OF_ROWS-3; i++) {
			for(int j=0; j<NO_OF_COLS; j++) {
				if(j<NO_OF_COLS-3) {
					if(board[i][j]!='O' && board[i][j]==board[i+1][j+1] &&
							board[i+1][j+1]==board[i+2][j+2] && board[i+2][j+2]==board[i+3][j+3]) {
						return true;
					}
				}
				if(j>2) {
					if(board[i][j]!='O' && board[i][j]==board[i+1][j-1] &&
							board[i+1][j-1]==board[i+2][j-2] && board[i+2][j-2]==board[i+3][j-3]) {
						return true;
					}
				}
			}	
		}
		return false;
	}
	public boolean isGridFull() {
		for(int i=0; i<NO_OF_COLS-1; i++)
		{
			if(!isColumnFull(i)) {
				return false;
			}
		}
		System.out.println("GAME OVER: No Winner!!");
		return true;
	}
}
