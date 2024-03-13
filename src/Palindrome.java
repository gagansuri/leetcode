public class Palindrome {

    public static void main(String[] args) {
        System.out.println("True : "+isPalindrome("nitin"));
        System.out.println("False :" +isPalindrome("nitin     "));
        System.out.println("False :"+isPalindrome("nitin   "));
        System.out.println("True :"+isPalindromeWithSpaces("nitin   "));
        System.out.println("False: "+isPalindromeWithSpaces("nitinn"));
    }

    static boolean isPalindrome(String s) {
        int left = 0 , right = s.length()-1;
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindromeWithSpaces(String s) {
        int left = 0 , right = s.length()-1;
        while(left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
