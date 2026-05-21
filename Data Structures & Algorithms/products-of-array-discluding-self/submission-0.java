class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixMult = new int[nums.length];
        int[] postfixMult = new int[nums.length];
        
        prefixMult[0] = 1;
        postfixMult[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixMult[i] = prefixMult[i-1] * nums[i-1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            postfixMult[i] = postfixMult[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
             result[i] = prefixMult[i] * postfixMult[i]; 
        }

        return result;

    }
}  
