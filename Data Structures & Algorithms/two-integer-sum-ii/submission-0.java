class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left <= right && left < numbers.length && right >= 0) {
            int currentSum = numbers[left] + numbers[right];
            if(currentSum == target) return pair(left + 1, right + 1);
            if(currentSum > target) {
                right--;
            }
            if(currentSum < target) {
                left++;
            }
        }

        return pair(-1, 1);
    }

    public int[] pair(int a, int b) {
        int[] res = new int[2];
        res[0] = a;
        res[1] = b;
        return res;
    }
}
