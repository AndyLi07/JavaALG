package leetcode;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 *
 * Given n and k, return the kth permutation sequence. (n will be between 1 and 9 inclusive)
 */
import java.util.LinkedList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
    	if(n==0) return "";

    	// calculate (n-1)!
    	int num = 1;
    	for(int i=1; i < n; i++) {
    		num = num * i;
    	}

    	boolean[] visited = new boolean[n];
    	k = k-1;

    	StringBuilder sb = new StringBuilder();

    	for(int i=0; i<n; i++) {
    		// there are (n-1)! number, start with 1, 2, ... n respectively.
    		// first bit is (k-1） / (n-1)!
    		// second bit is (k%num)/(n-2)!th unused number.
    		int index = k / num;
    		k = k % num;

    		for(int j = 0; j<n; j++) {
    			if(!visited[j]) {
    				if(index == 0) {
    					visited[j] = true;
    					sb.append((char)('1' + j));
    					sb.append(" ");
    					break;
    				}else{
    					index--;
    				}
    			}
    		}

    		if(i<n-1)
    			num = num / (n-1-i);
    	}

    	return sb.toString();
    }

    // use LinkedList to store unused number, delete from list when using the number
    public String getPermutation2(int n, int k) {
    	if(n==0) return "";

    	int num = 1;
    	for(int i=1; i < n; i++) {
    		num = num * i;
    	}

    	LinkedList<Character> unused = new LinkedList<>();
    	for(int i=0; i<n; i++) {
    		unused.add((char)('1' + i));
    	}

    	k = k-1;
    	StringBuilder sb = new StringBuilder();

    	for(int i=n-1; i>=0; i--) {
    		int index = k / num;
    		k = k % num;
    		sb.append(unused.get(index));
    		sb.append(" ");
    		unused.remove(index);

    		if(i>0)
    			num = num / i;
    	}

    	return sb.toString();
    }

    public static void main(String[] args) {
    	PermutationSequence sol = new PermutationSequence();
    	System.out.println(sol.getPermutation(4, 9));
    	System.out.println(sol.getPermutation2(4, 9));
    }
}
