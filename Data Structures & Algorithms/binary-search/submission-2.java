class Solution {
    public int search(int[] nums, int target) {
        return binSearch(nums, target, 0, nums.length - 1);
    }

    private int binSearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) {
            return binSearch(nums, target, mid + 1, end);
        } 
        else {
            return binSearch(nums, target, start, mid - 1);
        }
    }
}
