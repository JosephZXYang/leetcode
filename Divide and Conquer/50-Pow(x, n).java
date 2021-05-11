/**

Key points:

	1. Binary search approach is very fast
    2. -3 % 2 == -1 in Java
    
Difficulty: Medium

*/
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) return myPowHelper(1/x, -N, 1.0);
        else return myPowHelper(x, N, 1.0);
        
    }
    
    public double myPowHelper(double x, long n, double remainder) {
        if (n == 0) return 1;
        if (n == 1) return x * remainder;
        
        double r = remainder;
        
        if (n % 2 != 0) r *= x;
        
        return myPowHelper(x * x, n / 2, r);
    }
}