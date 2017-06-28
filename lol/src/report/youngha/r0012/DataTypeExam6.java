package report.youngha.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam6 extends DataTypeExam5 {

	public static void main(String [] args){
		ArrayList<HashMap> al = new ArrayList<HashMap>();
		DataTypeExam6 dte5 = new DataTypeExam6();
		for (int i = 0; i < 10; i++) {
			al.add(dte5.getHashMap());
		}
		for (HashMap hm : al) {
		System.out.print(hm.get("클래스")+"\t");
		System.out.print(hm.get("이름")+"\t");
		System.out.print(hm.get("나이")+"\t");
		System.out.println(hm.get("성별"));
	}
}
}
