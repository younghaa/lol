package report.youngha.r0011;

import java.util.Scanner;

public class ExceptionExam2 {
	// 10개의 방을 가지고 있는 int형 배열변수 arrNum을
	// ExceptionExam2의 멤버변수로 선언해주세요
	// for문을 돌며 Scanner 클래스의 nextLine()함수를 사용하여 아무런 값이나 입력해주세여
	// 단 for문을 돌며 문자값이 입력됬을때 에러메세지를 나오게 해주세요.
	// 에러가 걸릴경우 다시 입력하게한다.
	int[] arrNum = new int[10];

	public static void main(String[] args) {
		ExceptionExam2 ee2 = new ExceptionExam2();
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < ee2.arrNum.length; i++) {
			try {
				ee2.arrNum[i] = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				i--;
				System.out.println("응아니야");
			}
		}
	}
}
