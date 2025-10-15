class Solution {
    public int[] plusOne(int[] digits) {
        int result[] = new int[digits.length+1];
        int carry = 0 ;
        if(digits[digits.length - 1 ] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1]  +1;
            return digits;
        } else {
            for(int i = digits.length - 1 ; i >=0 ;i--) {
                if(digits[i] == 9) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    digits[i]+=carry;
                    carry = 0;
                    return digits;
                }
            }
        }
        if(carry == 1) {
            result[0] = 1;
            for (int i = 1 ; i < digits.length; i++) {
                result[i] = digits[i-1];
            }
        }
        
        return result;
    }
}