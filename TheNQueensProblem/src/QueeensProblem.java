
public class QueeensProblem {
	
	public static void main(String[] args) {
		queen();
	}
	public static void queen(){
		int[][] board = new int[8][8];
		boolean placeQueen = false;
		for(int y = 0; y<8; y++) {
			placeQueen = false;
			for(int x=0; x<8 && !placeQueen; x++) {
				if(board[y][x] == 0 && checkHorizontal(x, board) && checkVertical(y, board)&&checkDiagonal(y, x, board)) {
					board[y][x] = 1;
					placeQueen = true;
				}
			}
		}
		
		
	}
	public static boolean checkHorizontal(int x, int[][] board) {
		boolean clear = true;
		for(int y=0; y<8; y++) {
			if(board[y][x]!=0) {
				clear= false;
			}
		}
		return clear;
		
	}
	public static boolean checkVertical(int y, int[][] board) {
		boolean clear = true;
		for(int x=0; x<8; x++) {
			if(board[y][x]!=0) {
				clear= false;
			}
		}
		return clear;
		
	}
	public static boolean checkDiagonal(int y, int x, int[][] board) {
		int row = y;
		int col = x;
		boolean clear = true;
		for(int i =0; i<8; i++) {
			if(row+i<8&&col+i<8) {
				if(board[row+i][col+i]!=0) {
					clear=false;
				}
			}
		}
		for(int i =0; i<8; i++) {
			if(row-i>=0&&col-i>=0) {
				if(board[row-i][col-i]!=0) {
					clear=false;
				}
			}
		}
		for(int i =0; i<8; i++) {
			if(row+i<8&&col-i>=0) {
				if(board[row+i][col-i]!=0) {
					clear=false;
				}
			}
			
		}
		for(int i =0; i<8; i++) {
			if(row-i>=0&&col+i<8) {
				if(board[row-i][col+i]!=0) {
					clear=false;
				}
			}
		}
		return clear;
	}
	

}
