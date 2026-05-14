class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // This will store all valid triplets
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array so we can use the two pointer technique
        Arrays.sort(nums);

        // Pick one number at a time as the "fixed" first number
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate fixed numbers
            // This prevents repeated triplets like [-1, -1, 2] showing up twice
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Left pointer starts right after i
            int left = i + 1;
            // Right pointer starts at the end of the array
            int right = nums.length - 1;

            // Search for two numbers that work with nums[i]
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                // If the sum is too big, move right left to get a smaller number
                if (threeSum > 0) {
                    right--;
                }
                // If the sum is too small, move left right to get a bigger number
                else if (threeSum < 0) {
                    left++;
                }
                // If the sum equals 0, we found a valid triplet
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Move left to keep searching for more valid triplets
                    left++;
                    // Skip duplicate left values so we do not add the same triplet again
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}