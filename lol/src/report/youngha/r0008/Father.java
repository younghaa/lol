package report.youngha.r0008;

import java.util.Scanner;

public class Father {
	Scanner scan;
	String str1, str2;
	int initNum, maxNum;
	int[] arrNum = new int[10];
	
	Father(){
		scan = new Scanner(System.in);
		System.out.println("학생의 인원수를 입력해주세요 => ");
		int studentCnt = Integer.parseInt(scan.nextLine());
		arrNum = new int[studentCnt];
		System.out.println(studentCnt + "명 학생의 점수를 입력해주세요!!");
		inputPoint();
	}
	
	void inputPoint(){
		for(int i=0;i<arrNum.length;i++){
			arrNum[i] = Integer.parseInt(scan.nextLine());
		}
	}
	void printPoint(){
		for(int i=0;i<arrNum.length;i++){
			System.out.println(arrNum[i]);
		}
	}
	void castStringToInt(){
		initNum = Integer.parseInt(str1);
		maxNum = Integer.parseInt(str2);
	}
	void inputFormScanner1(){
		str1 = scan.nextLine();
	}
	void inputFormScanner2(){
		str2 = scan.nextLine();
	}
	
	void printIWithLoop(){
		for(int i=initNum;i<=maxNum;i++){
			System.out.println(i);
		}
	}
	
}
