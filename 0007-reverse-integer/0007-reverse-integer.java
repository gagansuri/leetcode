class Solution {
    public int reverse(int x) {
     // take the digits one by one and reverse

     long sum = 0 ;
     while(x != 0) {
        // take one digit
        int rem = x%10;
        x = x / 10;
        sum = sum*10 + rem;
        if( sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) return 0;
     }

     return (int)sum;   
    }
}