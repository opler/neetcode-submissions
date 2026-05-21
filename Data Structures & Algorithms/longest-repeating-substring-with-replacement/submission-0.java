class Solution {
    public int characterReplacement(String s, int k) {
        int[] countArr = new int[26];

        int ans = 0;
        int max = 0;

        int l = 0;
        int r = 0;

        while (r < s.length()) {
            countArr[s.charAt(r) - 'A']++;
            max = Math.max(max, countArr[s.charAt(r)-'A']);

            if (r-l+1 - max > k) {
                countArr[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
