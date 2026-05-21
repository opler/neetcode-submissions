class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();

        backtrack(nums, 0, res, sublist);

        return res;
    }

    public void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> sublist) {
        res.add(new ArrayList<>(sublist));

        for ( int i = start; i < nums.length; i++) {
            sublist.add(nums[i]);
            backtrack(nums, i + 1, res, sublist);
            sublist.remove(sublist.size() - 1);
        }
    }
}
