package report.youngha.r0005;

public class Cal {

	int a;//
	int b;// 클래스 안에서 변수 두개 선언
	String add;// 문자열변수한개선언

	Cal() {
	}

	Cal(int a) {
		//System.out.println(a + "인트형 변수 파라메터 한개를 가진 생성자를 호출하셨네요");
		this.a = a;
		this.b = b;

	}

	Cal(int a, int b, String add) {
		this.a = a;// 생성자에 대입
		this.b = b;//
		this.add = add;
		// TODO Auto-generated constructor stub
	}

	void printPlus() {
		System.out.println(a + " 과" + b + "의 연산결과");
	}

	void printCal() {
		if (add.equals("+")) {
			System.out.println(a + "+" + b + "=" + (a + b));
		} else if (add.equals("*")){
			System.out.println("빼기	: " + (a - b));
		} else if (add.equals("*")) {
			System.out.println("곱하기	: " + (a * b));
		} else if (add.equals("/")) {
			System.out.println("나누기	: " + (a / b));
		} else {
			System.out.println("ERROR");
		}
	}

	public static void main(String[] args) {
		Cal c = new Cal(10, 5, "+"); 

		c.printPlus();
		c.printCal();

	}
}
