class Solution {
    public int trap(int[] height) {
        int suffixMax = height[0];
        int[] prefixMaxes = new int[height.length];
        int[] suffixMaxes = new int[height.length];

        int currentPrefixMax = height[0];
        for(int i = 0; i < prefixMaxes.length; i++) {
            prefixMaxes[i] = height[i] > currentPrefixMax ? height[i] : currentPrefixMax;
            if(height[i] > currentPrefixMax) currentPrefixMax = height[i];
        }

        int currentSuffixMax = height[height.length - 1];
        for(int i = height.length - 1; i >= 0; i--) {
            suffixMaxes[i] = height[i] > currentSuffixMax ? height[i] : currentSuffixMax;
            if(height[i] > currentSuffixMax) currentSuffixMax = height[i];
        }

        int water = 0;
        for(int i = 0; i < height.length; i++) {
            water += Math.min(prefixMaxes[i], suffixMaxes[i]) - height[i];
        }

        return water;
    }
}
