class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i), 0);
            count++;
            map.put(s.charAt(i), count);
            count = map.getOrDefault(t.charAt(i), 0);
            count--;
            map.put(t.charAt(i), count);
        }

        for (Integer n : map.values()) {
            if (n < 0) return false;
        }
        return true;
    }
}
