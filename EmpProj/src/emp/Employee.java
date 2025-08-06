package emp;

public class Employee {
	public String num;
	public String name;
	public int sal;

	public Employee() {

	}

	Employee(String num, String name, int sal) {
		this.num = num;
		this.name = name;
		this.sal = sal;
	}

	public String info() {
		return String.format("사번: %s, 이름: %s, 급여: %d", num, name, sal);
	}
}
