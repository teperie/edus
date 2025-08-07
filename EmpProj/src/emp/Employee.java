package emp;

public abstract class Employee {
	public String num;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name;

	public abstract int getPay();

	public Employee() {

	}

	Employee(String num, String name) {
		setNum(num);
		setName(name);
	}

	@Override
	public String toString() {
		return String.format("사번: %s, 이름: %s, 급여: %d", num, name, getPay());
	}
}
