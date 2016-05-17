package ladder.binarysearch;
/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 *
 * sqrt(3) = 1, sqrt(10) = 3
 */
public class Sqrt {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // find the last number which square of it <= x
        if (x < 0) {
            return -1;
        }
        long start = 0;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                start = mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return (int) end;
        } else {
            return (int) start;
        }
    }

    public double sqrt(double x) {
    	double start = 0;
    	double end;
    	if (x < 1) {
    		end = 1;
    	} else {
    		end = x;
    	}

    	while ((end - start) > 1e-7) {
    		double mid = start + (end - start) / 2;
    		if (mid * mid <= x) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	return start; // or return end;
    }

    public static void main(String[] args) {
    	Sqrt sol = new Sqrt();
    	System.out.println(sol.sqrt(17));
    	System.out.println(sol.sqrt(0));
    	System.out.println(sol.sqrt(0.17));
    	System.out.println(sol.sqrt(32.0));
    }
}
