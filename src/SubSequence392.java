public class SubSequence392 {

    public static boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0 ) return true;
        boolean found = false;
        for(int i = 0,j=0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            found = false;
            for( ; j< t.length(); ) {
                if(c == t.charAt(j++)) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        System.out.println(isSubsequence(s,t));
    }
}
