import java.util.Scanner;

public class ArrayExam9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] result = {'A','A','A'}; // 도개걸윷모 순서: A=도, B=개, C=걸, D=윷, E=모

		// 3번의 윷놀이 진행
		for (int i = 0; i < 3; i++) {
			int count = 0; // 등 개수 카운트
			
			// 4개의 윷가락 입력받기
			for (int j = 0; j < 4; j++) {
				byte in = sc.nextByte();
				if (in > 0) { // 등(1)인 경우
					count++;
				}
			}
			
			// 등 개수에 따라 결과 결정 (도개걸윷모 순서)
			switch(count) {
				case 0: result[i] = 'D'; break; // 윷
				case 1: result[i] = 'A'; break; // 도
				case 2: result[i] = 'B'; break; // 개
				case 3: result[i] = 'C'; break; // 걸
				case 4: result[i] = 'E'; break; // 모
			}
		}
		
		// 결과 출력
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		sc.close();
	}
}

