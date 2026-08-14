class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroes = 0;
        int product = 1;
        for(int n: nums) {
            if(n == 0) zeroes++;
            else product *= n;
        }
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if(val == 0 && zeroes == 1) nums[i] = product;
            else if((val == 0 && zeroes > 1) || (val != 0 && zeroes > 0)) nums[i] = 0;
            else nums[i] = product / val;
        }
        return nums;
    }
}  
