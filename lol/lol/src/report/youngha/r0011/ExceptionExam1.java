package report.youngha.r0011;

import java.util.Scanner;

public class ExceptionExam1 {
	int num1;
	int num2;

	int plus() {
		return num1 + num2;
	}

	int minus() {
		return num1 - num2;
	}

	int multiple() {
		return num1 * num2;
	}

	int division() {
		return num1 / num2;
	}

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			ExceptionExam1 ee1 = new ExceptionExam1();
			ee1.num1 = Integer.parseInt(scan.nextLine());
			ee1.num2 = Integer.parseInt(scan.nextLine());

			int result = ee1.plus();
			System.out.println(result);
			result = ee1.minus();
			System.out.println(result);
			result = ee1.multiple();
			System.out.println(result);
			result = ee1.division();
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("숫자를 입력흐세여");
		}
		System.out.println("종료");
	}
}

// ExceptionExam1의 멤버변수로 int num1,num2를 선언
// 멤버변수 num1과 num2값을 계산하여 int 값을 리턴하는
// plus(),minus(),multiple(),division() 함수를 4개 선언하여 이름에 맞게 연산하여 리턴해주세요
// Scanner 클래스의 nextLine()함수를 사영하여 num1의 값과 num2값을 대입해주세요
// 숫자값을 입력하지 않았을때는 Exception에서 "숫자를 입력해야지!!" 라는 문자열이 나와야 합니다
// 정상적으로 숫자값을 입력했다면
// 위에 선언한 4개의 함수를 호출하여 값을 받아 출력하는 예제를 작성해 주시기 바랍니다.