import emp.Employee;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;
import emp.IBusinessTrip;

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

	public void regBusinessTrip(IBusinessTrip emp, int day) {
		emp.goBusinessTrip(day);
	}

	public static void main(String[] args) {
		Company com = new Company();
//		Employee emp1 = new Employee();
		Permanent emp1 = new Permanent("1001", "홍길동", 1000000);
		Sales emp2 = new Sales("1002", "고길동", 800000, 500000);
		PartTime emp3 = new PartTime("1003", "박길동", 160, 10000);
		PartTime emp4 = new PartTime("1004", "송길동", 160, 20000);

		com.regEmployee(emp1);
		com.regEmployee(emp2);
		com.regEmployee(emp3);
		com.regEmployee(emp4);

		com.allEmployeeInfo();
		System.out.println("총 급여: " + com.getAllTotalPay());		
		
		com.regBusinessTrip(emp2, 3);
		com.regBusinessTrip(emp3, 2);
		com.regBusinessTrip(emp4, 3);
		System.out.println("================================");

		com.getAllPartTime();
		com.allEmployeeInfo();
	}

}
