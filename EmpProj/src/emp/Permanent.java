package emp;

public class Permanent extends Employee {
	int salary;

	public Permanent(String id, String name, int salary) {
		setNum(id);
		setName(name);
		setSalary(salary);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return getSalary();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
