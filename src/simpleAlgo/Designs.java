package simpleAlgo;

public class Designs {
	public void crossDesign(String pattern) {
		int straight = 5;
		for (int i = 1; i <= straight; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 3)
					System.out.print(pattern);
				else {
					if (i == 3)
						System.out.print(pattern);
					else
						System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
