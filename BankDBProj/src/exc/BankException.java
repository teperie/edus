package exc;

import java.sql.SQLException;

public class BankException extends SQLException {
	ERR_CODE errCode;

	
	
	public BankException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankException(String reason, String sqlState, int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public BankException(String reason, String SQLState, int vendorCode) {
		super(reason, SQLState, vendorCode);
		// TODO Auto-generated constructor stub
	}

	public BankException(String reason, String sqlState, Throwable cause) {
		super(reason, sqlState, cause);
		// TODO Auto-generated constructor stub
	}

	public BankException(String reason, String SQLState) {
		super(reason, SQLState);
		// TODO Auto-generated constructor stub
	}

	public BankException(String reason, Throwable cause) {
		super(reason, cause);
		// TODO Auto-generated constructor stub
	}

	public BankException(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

	public BankException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BankException(String message, ERR_CODE errCode) {
		super(message);
		this.errCode = errCode;
	}

	public BankException(ERR_CODE errCode) {
		this.errCode = errCode;
	}

	@Override
	public String toString() {
		String message = "";
		if (getMessage() != null && getMessage().length() > 0) {
			message += "[" + getMessage() + "]";
		}

		switch (errCode) {
		case ACCID:
			message += "계좌번호가 틀립니다.";
			break;
		case DOUBLEID:
			message += "계좌번호가 중복됩니다.";
			break;
		case DEPOSIT:
			message += "입금액을 확인하세요.";
			break;
		case WITHDRAW:
			message += "잔액이 부족합니다.";
			break;
		case MENU:
			message += "선택한 메뉴가 바르지 않습니다.";
			break;
		default:
			message += "오류 발생";
		}
		return message;
	}
}
