import emp.Employee;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class Company {
	Employee[] employees = new Employee[100];
	int count = 0;

	void regEmployee(Employee employee) {
		employees[count++] = employee;
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
		return employee != null ? employee.toString() : num + "번 사원은 없는 사원입니다.";
	}

	int getAllTotalPay() {
		int total = 0;
		for (int i = 0; i < count; i++) {
			total += employees[i].getPay();
		}
		return total;
	}

	void allEmployeeInfo() {
		for (int i = 0; i < count; i++) {
			System.out.println(employees[i].toString());
		}
	}

	void getAllPartTime() {
		for (int i = 0; i < count; i++) {
			if (employees[i] instanceof PartTime) {
				System.out.println(employees[i].toString());
			}
		}
	}

	public static void main(String[] args) {
		Company com = new Company();
//		Employee emp1 = new Employee();
		Employee emp1 = new Permanent("1001", "홍길동", 1000000);
		Employee emp2 = new Sales("1002", "고길동", 800000, 500000);
		Employee emp3 = new PartTime("1003", "박길동", 10000, 160);

		com.regEmployee(emp1);
		com.regEmployee(emp2);
		com.regEmployee(emp3);

		com.allEmployeeInfo();
		System.out.println("총 급여: " + com.getAllTotalPay());

		com.getAllPartTime();
	}

}
