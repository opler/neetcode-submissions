class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, res, new ArrayList<String>());
        return res;
    }

    public void backtrack(String s, int start, List<List<String>> res, List<String> sublist) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(sublist));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPali(s, start, i)) {
                sublist.add(s.substring(start, i +1));
                backtrack(s, i+1, res, sublist);
                sublist.remove(sublist.size() - 1);
            }
        }
    }

    public boolean isPali(String s, int l, int r) {
        while ( l < r ) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
