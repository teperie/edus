package ex8;

class UnsupportedFuctionException extends Exception {

	private final int ERR_CODE;

	public UnsupportedFuctionException(String message, int errCode) {
		super(message);
		ERR_CODE = errCode;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "[" + ERR_CODE + "]" + super.getMessage();
	}

}

public class Exam9 {

	public static void main(String[] args) throws Exception {
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.", 100);
	}

}
