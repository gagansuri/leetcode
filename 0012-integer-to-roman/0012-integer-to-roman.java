class Solution {
    public String intToRoman(int num) {
    int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 , 5, 4, 1};
    String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX" , "V", "IV", "I"};
    StringBuilder result = new StringBuilder();
    for(int i = 0 ; i < numbers.length; i++) {
        int count = num/numbers[i];
        result.append(concat(count,roman[i]));
        num = num % numbers[i];
    }
    return result.toString();    
    }

    private String concat(int count, String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}