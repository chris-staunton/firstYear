
public class PaintThings {
	public static void main(String[] args) {

		// test
		Paint paintTank = new Paint(350);
		Rectangle deck = new Rectangle("deck", 20, 35);
		Sphere bigBall = new Sphere("bigBall", 15);
		Cylinder tank = new Cylinder("tank", 10, 30);

		double amountForDeck = paintTank.amount(deck);
		double amountForBall = paintTank.amount(bigBall);
		double amountForTank = paintTank.amount(tank);

	}

}
