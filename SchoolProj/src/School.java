import java.util.Arrays;

public class School {

	public static void main(String[] args) {
		School school = new School();

		Student stud1 = new Student();
		stud1.ban = 1;
		stud1.no = 1;
		stud1.kor = 80;
		stud1.eng = 90;
		stud1.math = 100;
		stud1.comment = "나는 경기도 안양의 이준영이다.";

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
		System.out.println(school.getAverage(1, 2)); // 70

		// 1반 전채 학생의 평균
		System.out.println(school.getBanAverage(1)); // 75

		// 1반 국어 성적 평균
		System.out.println(school.getBanKorAverage(1)); // 75
		// 1반 영어 성적 평균
		System.out.println(school.getBanEngAverage(1)); // 75
		// 1반 수학 성적 평균
		System.out.println(school.getBanMathAverage(1)); // 75

		// 전교 국어 성적 평균
		System.out.println(school.getKorAverage);
		// 전교 영어 성적 평균
		System.out.println(school.getEngAverage);
		// 전교 수학 성적 평균
		System.out.println(school.getMathAverage);

		// 1반 학생들의 성적순 정렬
		Student[] banStuds = school.banRank(1);
		Arrays.toString(banStuds);

		// 전교생 성적순
		Student[] studs = school.rank();
		Arrays.toString(studs);
	}

}
