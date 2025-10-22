class Solution {
    public boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();
        while(true) {
            n = calculateNext(n);
            if(n==1) return true;
            if(numbers.contains(n)) return false;

            numbers.add(n);
        }
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