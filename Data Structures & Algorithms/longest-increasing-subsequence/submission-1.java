class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            for(int j = i+1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) continue;

                dp[i] = Math.max(dp[i], dp[j] + 1);
                maxLength = Math.max(dp[i], maxLength);
            }
        }

        return maxLength;
    }
}
