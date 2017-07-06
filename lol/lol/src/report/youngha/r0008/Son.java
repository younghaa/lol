package report.youngha.r0008;

import report.youngha.r0008.Father;
import report.youngha.r0008.Son;


public class Son extends Father{
//	<<<<<<< HEAD

//	=======
		// 아빠 클래스에서  배열변수를 선언하시고 10명의 학생의 점수를 입력받아주세요.
		// 단 배열변수의 데이터 타입은 int형이여야 합니다.
		// 출력함수는 아빠 클래스에서 선언해주시고
		// 호출만 아들 클래스에서 해주시기 바랍니다.
//	>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git
		Son(){
//	<<<<<<< HEAD
			
			System.out.println("아들 기본생성자 호출!!");
//	=======
//	>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git
		} 
		Son(int a){
//	<<<<<<< HEAD
			
			System.out.println("오버로딩 개념으로 추가된 아들 생성자 호출!!");
//	=======
//	>>>>>>> branch 'master' of https://github.com/ParkKyoungHun/iot1_report.git
		}

		public static void main(String[] args){
			Son s = new Son();
			s.printPoint();
		}
	}



