class Solution {
    public boolean isPowerOfFour(int n) {
        // for(int i = 1;i <= )
        if(n <= 0) {
            return false;
        }

        while(n % 4 == 0) {
            n /= 4;
        }
        
        return n == 1;
    }
}