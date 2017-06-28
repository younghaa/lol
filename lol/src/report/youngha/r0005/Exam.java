package report.youngha.r0005;

public class Exam {

	public static void main(String[] args) {
//		Robot r = new Robot("지로봇", 10);

		// r.doKick();
		// r.doRun();
		// r.doChange();

		for (int i = 1; i <= 10; i++) {
				Cal c = new Cal(i, (11-i), "+");
				c.printCal();
				// c = new Cal(10, 2, "-");
				// c.printCal();
				// c = new Cal(10, 2, "*");
				// c.printCal();
				// c = new Cal(10, 2, "/");
				// c.printCal();

			}
		}
	}

