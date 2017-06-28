package report.youngha.r0005;

public class Robot {

	String name;
	int age;

	public Robot(String name,int age) {
		this.name = name;
		this.age = age;
	}

	void doKick() {
		System.out.println(age +"살 먹은 로봇 "+name+"이(가) 발로 찹니다.");
	}

	void doRun() {
		System.out.println(age +"살 먹은 로봇 "+name+"이(가) 달립니다.");
	}

	void doChange() {
		System.out.println(age +"살 먹은 로봇 "+name+"이(가) 변신합니다.");
	}

	public static void main(String[] args) {
		Robot r = new Robot("태권브이",3);
		r.doKick();
		r.doRun();
		r.doChange();
	}
}
