class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new HashSet<Integer>(), new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, Set<Integer> subset, List<Integer> sublist) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<Integer>(sublist));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (subset.contains(nums[i])) {
                continue;
            }
            subset.add(nums[i]);
            sublist.add(nums[i]);
            dfs(nums, res, subset, sublist);
            subset.remove(nums[i]);
            sublist.remove(sublist.size() - 1);
        }

        
    }
}
