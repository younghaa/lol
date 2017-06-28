package report.youngha.r0013;

public class Minus implements InterfaceExam{

	@Override
	public String getString() {

		return "Exam의 getString() 함수 호출";
	}

	@Override
	public void setString(String str) {
		System.out.println("Exam의 setString()함수 호출!" + str);

	}


	public int cal(int a, int b){
		return a-b;
	}

}
