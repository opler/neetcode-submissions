class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return  res;
        }
        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "qprs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");
        backtrack(digits, res, "", digitToChar, 0);
        return res;
    }

    public void backtrack(String digits, List<String> res, String resString, Map<Character, String> digitToChar, int start) {
        if (resString.length() == digits.length()) {
            res.add(resString);
            return;
        }

        for (char c : digitToChar.get(digits.charAt(start)).toCharArray()) {
            resString += c;
            backtrack(digits, res, resString, digitToChar, start + 1);
            resString = resString.substring(0, resString.length() - 1);
        }
    }
}
