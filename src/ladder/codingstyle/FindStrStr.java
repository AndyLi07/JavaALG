package ladder.codingstyle;

public class FindStrStr {
	/**
 	 * Returns a index to the first occurrence of target in source,
	 * or -1  if target is not part of source.
	 * @param source string to be scanned.
	 * @param target string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
		// always handle corner cases first
		if (source == null || target == null) {
			return -1;
		}
		for (int i = 0; i < source.length() - target.length() + 1; i++) {
			int j = 0;
			for (j = 0; j < target.length(); j++) {
				if (source.charAt(i + j) != target.charAt(j)) {
					break;
				}
			}
			if (j == target.length()) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String source = "source";
		String target = "target";
		FindStrStr sol = new FindStrStr();
		System.out.println(sol.strStr(source, target));

		source = "abcdabcdefg";
		target = "bcd";
		System.out.println(sol.strStr(source, target));
	}
}