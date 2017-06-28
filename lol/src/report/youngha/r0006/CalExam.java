package report.youngha.r0006;

import java.util.Scanner;

public class CalExam {
	int getGradeFromArray(int[] arrNum,int num){
		for(int i=0;i<arrNum.length;i++){
			if(arrNum[i]==num){
				return i+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;// *result 선언 까먹음
		int[] a = new int[10];
		int[] b= new int [10];
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("학생 " + (i + 1) + "의 점수를 입력 받으십시오");
			String input = scanner.nextLine();
			a[i] = Integer.parseInt(input);// *Integer			
			b[i] = Integer.parseInt(input);		
			result += Integer.parseInt(input);
		
		}
		for (int j = 0; j < a.length; j++) {
			System.out.println("학생 " + (j + 1) + "의 점수 :\t" + a[j]);
			
		}
		System.out.println("\n" + "학생들의 총점 : " + result);
		System.out.println("학생들의 평점 : " + (result / a.length) + "\n");

		for (int i = 0; i < a.length; i++) {		//for문을 사용해
			for (int j = i+1; j <a.length; j++) {	//오름차순 내림차순 설정 가능
				if (a[i] < a[j]) {
					int tmp;
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		CalExam ce=new CalExam();
		for (int i = 0; i <a.length ; i++) {//*차순정렬 프린트 구간
			System.out.println((i+1)+"등\t"+a[i]+"점");	//*
			System.out.println(" " + ce.getGradeFromArray(b, a[i])+"번 학생");
		}
	}
}
			
			
//			CalExam ce=new CalExam();
//			ce.getGradeFromArray(a[i],);
//			System.out.println("학생 "+ +"의 점수 :"+ a[i]);
