class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, res, new ArrayList<Integer>());
        return res;
    }

    public void subsets(int[] nums, int start, List<List<Integer>> res, List<Integer> sublist) {
        
        res.add(new ArrayList<Integer>(sublist));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            sublist.add(nums[i]);
            subsets(nums, i + 1, res, sublist);
            sublist.remove(sublist.size() - 1);
        }
    }
}
