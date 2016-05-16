package leetcode;

public class Calculate {

	private static double log2(double a) {
		return Math.log(a)/Math.log(2);
	}
	

	public static void main(String[] args) {

		// double bl1 = - 4 * 0.1 * log2(0.1 / 0.5) - 0.2 * log2(0.2 / 0.5) - 0.4 * log2(0.4 / 0.5);
		// System.out.println(bl1);
		
		// bl1 = - 2 * 0.2 * log2(0.2 / 0.5) - 0.1 * log2(0.1 / 0.5);
		// System.out.println(bl1);

		// bl1 = - 0.5 * log2(0.5 / 0.8) - 0.2 * log2(0.2 / 0.8) - 0.1 * log2(0.1 / 0.8) - 2 * 0.1 * log2(0.1 / 0.2);
		// System.out.println(bl1);

		// bl1 =  - 0.4 * log2(0.4 / 0.7) - 0.2 * log2(0.2 / 0.7) - 0.1 * log2(0.1 / 0.7) - 0.1 * log2(0.1 / 0.3) - 0.2 * log2(0.2 / 0.3);
		// System.out.println(bl1);

		// double bl2 =  - 0.2 * log2(0.2 / 0.4) - 2 * 0.1 * log2(0.1 / 0.4) ;
		// System.out.println(bl2);

		// bl2 = - 0.2 * log2(0.2 / 0.3) - 0.1 * log2(0.1 / 0.3) - 2 * 0.1 * log2(0.1 / 0.2);
		// System.out.println(bl2);
		// bl2 = - 0.2 * log2(0.2 / 0.3) - 0.1 * log2(0.1 / 0.3);
		// System.out.println(bl2);

		double bl1 = - 2 * 0.2 * log2(0.2 / 0.4) - 0.2 * log2(0.2 / 0.6) - 0.4 * log2(0.4 / 0.6);
		System.out.println(bl1);

		bl1 = - 2*0.2 * log2(0.2 / 0.5)- 0.1 * log2(0.1 / 0.5) - 0.1 * log2(0.1 / 0.5) - 0.4 * log2(0.4 / 0.5);
		System.out.println(bl1);

		bl1 = - 2*0.1 * log2(0.1 / 0.5)- 4*0.2 * log2(0.2 / 0.5);
		System.out.println(bl1);
	}

}
