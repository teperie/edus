import java.util.Arrays;

public class School {
	Student[] students = new Student[100];
	int count;

	public void regStudent(Student student) {
		students[count++] = student;
	}

	public Student searchByBanNo(int ban, int no) {
		Student student = null;
		for (int i = 0; i < count; i++) {
			if (students[i].ban == ban && students[i].no == no) {
				student = students[i];
				break;
			}
		}
		return student;
	}

	public void getScore(int ban, int no) {
		Student student = searchByBanNo(ban, no);
		if (student == null) {
			System.out.println("학생 정보가 틀립니다");
			return;
		}

		System.out.println(student.info());
	}

	public float getStudentAverage(int ban, int no) {
		Student student = searchByBanNo(ban, no);
		if (student == null) {
			System.out.println("학생 정보가 틀립니다.");
			return 0;
		}
		return student.getAverage();
	}

	public float getBanAverage(int ban) {
		float avg = 0f;
		int studCnt = 0;
		for (int i = 0; i < count; i++) {
			if (students[i].ban == ban) {
				studCnt++;
				avg += students[i].getAverage();
			}
		}
		return avg / studCnt;
	}

	public float getBanKorAverage(int ban) {
		int total = 0;
		int studCnt = 0;
		for (int i = 0; i < count; i++) {
			if (students[i].ban == ban) {
				total += students[i].kor;
				studCnt++;
			}
		}

		return (float) total / studCnt;
	}

	public float getBanEngAverage(int ban) {
		int total = 0;
		int studCnt = 0;
		for (int i = 0; i < count; i++) {
			if (students[i].ban == ban) {
				total += students[i].eng;
				studCnt++;
			}
		}

		return (float) total / studCnt;
	}

	public float getBanMathAverage(int ban) {
		int total = 0;
		int studCnt = 0;
		for (int i = 0; i < count; i++) {
			if (students[i].ban == ban) {
				total += students[i].math;
				studCnt++;
			}
		}

		return (float) total / studCnt;
	}

	public float getKorAverage() {
		int total = 0;
		for (int i = 0; i < count; i++) {
			total += students[i].kor;
		}
		return (float) total / count;
	}

	public float getEngAverage() {
		int total = 0;
		for (int i = 0; i < count; i++) {
			total += students[i].eng;
		}
		return (float) total / count;
	}

	public float getMathAverage() {
		int total = 0;
		for (int i = 0; i < count; i++) {
			total += students[i].math;
		}
		return (float) total / count;
	}

	public Student[] bubbleSort(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].getAverage() < students[j + 1].getAverage()) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
		return students;
	}

	public Student[] banRank(int ban) {
		Student[] banStuds = new Student[100];
		int studCnt = 0;
		for (int i = 0; i < count; i++) {
			if (students[i].ban == ban) {
				banStuds[studCnt++] = students[i];
			}
		}

		Student[] filterStud = new Student[studCnt];
		System.arraycopy(banStuds, 0, filterStud, 0, studCnt);
		return bubbleSort(filterStud);
	}

	public Student[] rank() {
		Student[] cpyStuds = new Student[count];
		System.arraycopy(students, 0, cpyStuds, 0, count);
		return bubbleSort(cpyStuds);
	}

	public static void main(String[] args) {
		School school = new School();

		Student stud1 = new Student();
		stud1.ban = 1;
		stud1.no = 1;
		stud1.kor = 80;
		stud1.eng = 90;
		stud1.math = 100;

		Student stud2 = new Student(1, 2, 88, 77, 99);
		Student stud3 = new Student(2, 1, 80, 80, 80);
		Student stud4 = new Student(2, 2, 90, 90, 90);

		school.regStudent(stud1);
		school.regStudent(stud2);
		school.regStudent(stud3);
		school.regStudent(stud4);

		// 1반 2번의 점수
		school.getScore(1, 2); // 반: 1, 번호: 2, 국어: 70, 영어: 70, 수학: 70, 총점: 210, 평균: 70)

		// 1반 2번 학생의 평균
		System.out.println(school.getStudentAverage(1, 2)); // 70

		// 1반 전채 학생의 평균
		System.out.println(school.getBanAverage(1)); // 75

		// 1반 국어 성적 평균
		System.out.println(school.getBanKorAverage(1)); // 75
		// 1반 영어 성적 평균
		System.out.println(school.getBanEngAverage(1)); // 75
		// 1반 수학 성적 평균
		System.out.println(school.getBanMathAverage(1)); // 75

		// 전교 국어 성적 평균
		System.out.println(school.getKorAverage());
		// 전교 영어 성적 평균
		System.out.println(school.getEngAverage());
		// 전교 수학 성적 평균
		System.out.println(school.getMathAverage());

		// 1반 학생들의 성적순 정렬
		Student[] banStuds = school.banRank(1);
		Arrays.toString(banStuds);

		// 전교생 성적순
		Student[] studs = school.rank();
		Arrays.toString(studs);
	}

}
