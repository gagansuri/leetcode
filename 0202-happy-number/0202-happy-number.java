class Solution {
    public boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();
        int slow = n , fast = calculateNext(n);
        while(slow != fast) {
            slow = calculateNext(slow);
            if(slow==1) return true;
            fast = calculateNext(calculateNext(fast));
        }
        return slow == 1;
    }

    int calculateNext(int n) {
        //123
        
        int sum = 0 ;
        while(n != 0) {
            int d = n%10;
            sum+=d*d;
            n = n/10;
        }
    return sum;
    }
}