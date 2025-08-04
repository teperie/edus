package chapter6;

class Card {
	int number;
	String kind;

	static int width = 150;
	static int height = 200;
}

public class StaticTest1 {

	public static void main(String[] args) {
		System.out.println(Card.width);
		Card.height = 250;
		System.out.println(Math.PI);

		Card card = new Card();
		card.kind = "diamond";
		card.number = 7;

		System.out.printf("모양: %s, 번호: %d, 가로: %d, 세로: %d\n", card.kind, card.number, Card.width, Card.height);
	}

}
