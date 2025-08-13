package ex11;

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public boolean equals(Object obj) {
		if (obj instanceof SutdaCard) {
			SutdaCard c = (SutdaCard) obj;
			return num == c.num && isKwang == c.isKwang;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return num + (isKwang ? "K" : "");
	}

	@Override
	public int hashCode() {
		return (num + (isKwang ? "kwang" : "")).hashCode();
	}

}