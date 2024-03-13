public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder resultReverse = new StringBuilder();
        String[] words = s.split(" ");
        for(int i = words.length - 1 ; i >= 0 ; i--) {
            String word = words[i];
            if(!word.equals("")) {
                resultReverse.append(word).append(" ");
            }
        }
        return resultReverse.substring(0,resultReverse.length()-1).toString();
    }
}
