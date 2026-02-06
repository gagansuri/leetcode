class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c != '#') {
                sStack.push(c);
            } else {
                if(!sStack.isEmpty()) sStack.pop();
            }
        }

        for(char c : t.toCharArray()) {
            if(c != '#') {
                tStack.push(c);
            } else {
                if(!tStack.isEmpty()) tStack.pop();
            }
        }

        StringBuilder sbS = new StringBuilder();
        StringBuilder tbS = new StringBuilder();
        while(!sStack.isEmpty()) sbS.append(sStack.pop());
        while(!tStack.isEmpty()) tbS.append(tStack.pop());
        System.out.println( " s : " + sbS + " t :" + tbS);
        return sbS.toString().equals(tbS.toString());
    }
}