class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int next = i == nums.length - 1 ? 1 : nums[i + 1];
            prod *= next;
            output[i] = prod;
        }
        prod = 1;
        for (int i = 0; i < nums.length; i++) {
            int prev = i == 0 ? 1 : nums[i - 1];
            prod *= prev;
            output[i] *= prod;
        }
        return output;
    }
}  
