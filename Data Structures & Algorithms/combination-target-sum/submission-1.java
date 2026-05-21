class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combSum(nums, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void combSum(int[] nums, int target, int start, List<Integer> sublist, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(sublist));
            return;
        }
        if (target < 0) {
            return;
        }
        for ( int i = start; i < nums.length; i++ ) {
            sublist.add(nums[i]);
            combSum(nums, target - nums[i], i, sublist, res);
            sublist.remove(sublist.size() - 1);
        }
    }
}
