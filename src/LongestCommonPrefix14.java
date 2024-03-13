public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String  longestCommonPrefix(String[] strs) {
        int i = 0 ;
        StringBuilder sb = new StringBuilder();
        for(Character c : strs[0].toCharArray()) {
            boolean found = true;
            for(int j = 1; j< strs.length; j++) {
                if(strs[j].charAt(i) != c) {
                    found = false;
                    return sb.toString();
                }
            }
            if(found) {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
}
