class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Left pointer starts at the beginning of the sorted array
        int left = 0;
        // Right pointer starts at the end of the sorted array
        int right = numbers.length - 1;

        // Keep searching while the two pointers have not crossed
        while (left < right) {
            // Add the two numbers at the current pointer positions
            int currentSum = numbers[left] + numbers[right];
            // If the sum is too large, move right pointer left
            // because the array is sorted, so moving left gives a smaller number
            if (currentSum > target) {
                right--;
            }
            // If the sum is too small, move left pointer right
            // because the array is sorted, so moving right gives a larger number
            else if (currentSum < target) {
                left++;
            }
            // If the sum equals target, we found the answer
            else {
                // The problem wants 1-indexed positions, so add 1 to both indices
                return new int[] { left + 1, right + 1 };
            }
        }
        // This line is usually never reached because the problem guarantees one solution
        return new int[] {};
    }
}