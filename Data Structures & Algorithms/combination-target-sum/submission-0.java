class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, target, 0, res, subset);

        return res;

    }

    public void dfs(int[] nums, int target, int index, List<List<Integer>> res, List<Integer> subset) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (target < 0 || index >= nums.length) {
            return;
        }

        // taking the num list totally
        subset.add(nums[index]);
        dfs(nums, target - nums[index], index, res, subset);

        // not taking the number from the list
        subset.remove(subset.get(subset.size() - 1));
        dfs(nums, target, index + 1, res, subset);
    }
}
