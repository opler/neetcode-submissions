class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (runningSum < 0) {
                runningSum = 0;
            }
            runningSum = runningSum + nums[i];
            max = Math.max(max, runningSum);
        }
        return max;
    }
}
