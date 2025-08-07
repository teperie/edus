package ex7;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		/*
		 * (1) 배열 SutdaCard를 적절히 초기화 하시오.
		 */

		for (int i = 0; i < 10; i++) {
			boolean isKwang = false;
			int cardNum = i + 1;
			if (cardNum == 1 || cardNum == 3 || cardNum == 8)
				isKwang = true;
			cards[i] = new SutdaCard(cardNum, isKwang);
			cards[i + 10] = new SutdaCard(cardNum, false);
		}
	}

	void shuffle() {
		for (int i = 0; i < 500; i++) {
			int c1 = (int) (Math.random() * CARD_NUM);
			int c2 = (int) (Math.random() * CARD_NUM);

			SutdaCard temp = cards[c1];
			cards[c1] = cards[c2];
			cards[c2] = temp;
		}
	}

	SutdaCard pick(int index) {
		if (index < 0 || index >= CARD_NUM)
			return null;
		return cards[index];
	}

	SutdaCard pick() {
		return cards[(int) (Math.random() * CARD_NUM)];
	}
}