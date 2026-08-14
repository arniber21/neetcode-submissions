class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if(Math.min(heights[left], heights[right]) == heights[left]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
