class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] output = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            for (int n : buckets[i]) {
                output[index++] = n;
                if (index == k) {
                    return output;
                }
            } 
        }
        return output;

        

    }
}
