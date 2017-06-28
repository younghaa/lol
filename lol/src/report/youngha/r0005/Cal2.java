package report.youngha.r0005;

public class Cal2 {
	int num1;
	int num2;
	String operator;

	
	Cal2(int num1, int num2, String operator) {
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}

	void printPlus() {
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
	}
	void printMinus() {
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
	}
	void printMultiple() {
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
	}
	void printDivision() {
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
	}
	
	
	public static void main(String[] args) {
		Cal2 c2 = new Cal2(10,2,"");
		c2.printPlus();
		c2.printMinus();
		c2.printMultiple();
		c2.printDivision();

	}
}

// int형변수2개를 멤버변수로(클래스내부에서생성)
// 스트링형변수1개선언
// num1,num2,operator