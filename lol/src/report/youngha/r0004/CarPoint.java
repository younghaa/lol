package report.youngha.r0004;

import java.util.Scanner;

public class CarPoint {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		int[] n = new int[6];
		for (int i = 0; i < n.length; i++) {
			System.out.print("학생 " + (i + 1) + "의 점수를 입력해주세요");
			String input = scanner.nextLine();
			n[i] = Integer.parseInt(input);

			result += n[i];// result +n[1]+n[2]+......n[n.length];

		}
		for (int i = 0; i < n.length; i++) {
			int k=i+1;
			System.out.println("학생 " + k + "의 점수 : " + n[i]);
		}
		System.out.println("학생들의 총점 : " + result + "\n");
		System.out.println("학생들의 평균 : " + (result / n.length));

		System.out.println("내림차순정렬");
		for (int i = 0; i < n.length; i++) {
			for (int j = i + 1; j < n.length; j++) {

				if (n[i] < n[j]) {
					int tmp;
					tmp = n[i];
					n[i] = n[j];
					n[j] = tmp;
				}
			}
		}
		for(int i=0;i<n.length;i++){
			System.out.println(n[i]);
	}
	}
}

	
		
		/*System.out.print("학생1의 점수를 입력해 주세요.");
		String input = scanner.nextLine();
		System.out.println("학생1의 점수 : "+input);

		System.out.print("학생2의 점수를 입력해 주세요.");
		String input2 = scanner.nextLine();
		System.out.println("학생2의 점수 : "+input2);
		
		System.out.print("학생3의 점수를 입력해 주세요.");
		String input3 = scanner.nextLine();
		System.out.println("학생3의 점수 : "+input3);
		
		System.out.print("학생4의 점수를 입력해 주세요.");
		String input4 = scanner.nextLine();
		System.out.println("학생4의 점수 : "+input4);
		
		System.out.print("학생5의 점수를 입력해 주세요.");
		String input5 = scanner.nextLine();
		System.out.println("학생5의 점수 : "+input5);
		
		System.out.print("학생6의 점수를 입력해 주세요");
		String input6 = scanner.nextLine();
		System.out.println("학생6의 점수 : "+input6);
		
		int n1 = Integer.parseInt(input);
		int n2 = Integer.parseInt(input2);
		int n3 = Integer.parseInt(input3);
		int n4 = Integer.parseInt(input4);
		int n5 = Integer.parseInt(input5);
		int n6 = Integer.parseInt(input6);
		
		int i = n1+n2+n3+n4+n5+n6;
		System.out.println("학생들의 총점 = "+(i));
		System.out.println("학생들의 평균 점수 = " +(i/6));*/


