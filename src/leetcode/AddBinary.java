package leetcode;

/* 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * For example, a = "11", b = "1", Return "100".
 */

public class AddBinary {
	public String addBinary(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();

		// pad the string to have same length
		if(len1<len2) {
			a = padString(a, len2-len1);
		}else {
			b = padString(b, len1-len2);
		}

		int carry = 0;
		String res = "";

		for(int i = a.length() - 1; i >= 0; i--) {
			// convert from char to int
			// Integer.parseInt(String) cannot be used here
			int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry ;
			carry = sum / 2 ;
			res = String.valueOf(sum % 2) + res;
		}

		if (carry == 1){
			res = "1" + res;
		}

		return res;
	}

	private String padString(String s, int padding) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < padding; i++) {
			sb.append("0");
		}
		sb.append(s);
		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "101";
		String b = "1111";
		AddBinary sol = new AddBinary();
		System.out.println(a + " + " + b + " = " + sol.addBinary(a, b));
	}
}
