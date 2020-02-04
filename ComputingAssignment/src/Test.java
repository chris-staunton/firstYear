
public class Test {
move(boardAddress, columnIndex, token){
	bottomRow = 5
	rowSize = 7
	rowIndex = 5
	if(boundery<0)
	{
		end
	}
	else
	{
		startOfRow = rowIndex*rowIndex
		addressOffset = startOfRow + columnIndex
		token = memLocztion[boardAddress + addressOffset]
		if(token == 0) {
			place token in game board
		}
		else {
			move to next row up
		}
	}
}
	
}
