
public class Company {
	Employee[] employees = new Employee[100];
	int count = 0;

	void regEmployee(Employee employee) {
		employees[count++] = employee;
	}

	void paySalary(String num, int pay) {
		getEmployeeByNum(num).sal = pay;
	}

	Employee getEmployeeByNum(String num) {
		Employee employee = null;
		for (int i = 0; i < count; i++) {
			if (employees[i].num.equals(num)) {
				employee = employees[i];
				break;
			}
		}
		return employee;
	}

	String empInfo(String num) {
		Employee employee = getEmployeeByNum(num);
		return employee != null ? employee.info() : num + "번 사원은 없는 사원입니다.";
	}

	int getTotalEmpSal() {
		int total = 0;
		for (int i = 0; i < count; i++) {
			total += employees[i].sal;
		}
		return total;
	}

	void allEmpInfo() {
		for (int i = 0; i < count; i++) {
			System.out.println(employees[i].info());
		}
	}

	public static void main(String[] args) {
		Company com = new Company();
		Employee emp1 = new Employee();
		emp1.num = "1001";
		emp1.name = "홍길동";
		emp1.sal = 1000000;

		com.regEmployee(emp1);
		System.out.println(com.empInfo("1001"));
		com.paySalary("1001", 1500000);
		System.out.println(com.empInfo("1001"));

		Employee emp2 = new Employee();
		emp2.num = "1001";
		emp2.name = "고길동";
		emp2.sal = 2000000;
		com.regEmployee(emp2);

		System.out.println("총 급여: " + com.getTotalEmpSal());
		com.allEmpInfo();
	}

}
