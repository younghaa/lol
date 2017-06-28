package report.youngha.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataTypeExam4 {

	public static void main(String[] args) {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		Scanner scan = new Scanner(System.in);
		
		HashMap hm = new HashMap();
		hm.put("클래스", "A");
		hm.put("이름", "홍길동");
		hm.put("나이", "20");
		hm.put("성별", "남자");
		list.add(hm);
		
		HashMap hm1 = new HashMap();
		hm1.put("클래스", "B");
		hm1.put("이름", "길정이");
		hm1.put("나이", "25");
		hm1.put("성별", "남자");
		list.add(hm1);
		
		HashMap hm2 = new HashMap();
		hm2.put("클래스", "C");
		hm2.put("이름", "윤정이");
		hm2.put("나이", "22");
		hm2.put("성별", "여자");
		list.add(hm2);

		HashMap hm3 = new HashMap();
		hm3.put("클래스", "C");
		hm3.put("이름", "둥둥이");
		hm3.put("나이", "5");
		hm3.put("성별", "여자");
		list.add(hm3);
		
		System.out.println("클래스\t" +"ㅣ이름\t"+"ㅣ나이\t"+"ㅣ성별");
		for (int i=0; i<list.size();i++){
			HashMap resultHm= list.get(i);
			System.out.print(resultHm.get("클래스")+"\tㅣ");
			System.out.print(resultHm.get("이름")+"\tㅣ");
			System.out.print(resultHm.get("나이")+"\tㅣ");
			System.out.println(resultHm.get("성별"));
		}
	}
}
