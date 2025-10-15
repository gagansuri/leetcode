class Solution {
    public int[] plusOne(int[] digits) {
       int[] res = new int[digits.length + 1];
       int carry = 1 ;
       for(int i = digits.length - 1 ; i >= 0 ; i--) {
        int sum = digits[i] + carry ;
        res[i] = sum % 10;
        carry = sum / 10;
       }
       
       if(carry > 0 ) {
        res[0] = carry;
       } else {
        res = Arrays.copyOf(res, res.length - 1);
       }
       return res;
    }
}