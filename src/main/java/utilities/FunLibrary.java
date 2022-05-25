package utilities;

import java.util.Random;

public class FunLibrary {

	public static int getRandomNumber(int num) {

		Random random = new Random();
		int randomWithNextInt = random.nextInt(num);
		System.out.println("The random no is " +randomWithNextInt);
		return randomWithNextInt;
	}
}
