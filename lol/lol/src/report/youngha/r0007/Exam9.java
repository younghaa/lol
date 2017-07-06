package report.youngha.r0007;

import java.util.Scanner;

public class Exam9 {

	private int a;
	private int b;
	private int result;
	Scanner scan;
	public Exam9(){
		scan = new Scanner(System.in);
	}
	public void inputA(){
		System.out.println("초기값 입력 => ");
		this.a = Integer.parseInt(scan.nextLine());
	}
	public void inputB(){
		System.out.println("맥스값 입력 => ");
		this.b=Integer.parseInt(scan.nextLine());
	}
	public void doLoop(){
		for(int i=a;i<=b;i++){
			result+=i;
			
		}
	}
	public int getResult(){
		return result;
		
	}
}
