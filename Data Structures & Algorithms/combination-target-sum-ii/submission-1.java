class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }

    public void backtrack(int[] nums, int target, int start, List<List<Integer>> res, List<Integer> sublist) {
        if (target == 0) {
            res.add(new ArrayList<>(sublist));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;

            sublist.add(nums[i]);
            backtrack(nums, target - nums[i], i + 1, res, sublist);
            sublist.remove(sublist.size() - 1);
        }
    }
}
