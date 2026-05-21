class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if ( c == '(') {
                res.append(c);
                count++;
            } else if (c == ')' && count > 0) {
                res.append(c);
                count--;
            } else if (c != ')') {
                res.append(c);
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = res.length() - 1; i >= 0; i--) {
            char c = res.charAt(i);
            if (c == '(' && count > 0) {
                count--;
            } else {
                output.append(c);
            }
        }

        return output.reverse().toString();
    }
}