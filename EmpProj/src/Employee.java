
public class Employee {
	String num;
	String name;
	int sal;

	Employee() {

	}

	Employee(String num, String name, int sal) {
		this.num = num;
		this.name = name;
		this.sal = sal;
	}

	String info() {
		return String.format("사번: %s, 이름: %s, 급여: %d", num, name, sal);
	}
}
