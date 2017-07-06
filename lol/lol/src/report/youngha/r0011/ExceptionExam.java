package report.youngha.r0011;

import java.util.Scanner;

public class ExceptionExam {

	
		public static void main(String[] args){
			Scanner scan = new Scanner(System.in);
			System.out.println("값좀 넣어봐");
			String str=scan.nextLine();
			int a= Integer.parseInt(str);
			
			System.out.println("숫자만넣었구나"+a);
		}
}
