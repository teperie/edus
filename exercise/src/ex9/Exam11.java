package ex9;

enum ERR_CODE {
	UNKNOWN, NUMBER_FORMAT, OUTBOUNDS
}

class GugudanException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 679253127609659365L;
	String message = "USAGE : GugudanTest 3 5";
	private final ERR_CODE CODE;

	GugudanException() {
		this("", ERR_CODE.UNKNOWN);
	}

	GugudanException(ERR_CODE code) {
		super();
		CODE = code;
	}

	GugudanException(String message, ERR_CODE code) {
		super(message);
		CODE = code;
	}

	@Override
	public String toString() {
		ERR_CODE err = this.CODE;
		String message = "";

		switch (err) {
		case NUMBER_FORMAT:
			message += "시작 단과 끝 단, 두 개의 정수를 입력해주세요.";
			break;
		case OUTBOUNDS:
			message += "단의 범위는 2와 9 사이의 값이어야 합니다.";
			break;
		case UNKNOWN:
		default:
			message += "몰라";
			break;
		}
		return message += "\n" + this.message;
	}

}

public class Exam11 {

	public static void main(String[] args) {

		int from = 0, to = 0;

		try {
			from = Integer.parseInt(args[0]);
			to = Integer.parseInt(args[1]);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			throw new GugudanException(ERR_CODE.NUMBER_FORMAT);
		}

		if (from < 2 || to > 9) {
			throw new GugudanException(ERR_CODE.OUTBOUNDS);
		}

		for (int i = from; i <= to; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d*%d=%d\n", i, j, i * j);
			}
			System.out.println();
		}
	}

}
