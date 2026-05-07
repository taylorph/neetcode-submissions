class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Stores each number we have seen so far and its index.
        // Key: number from nums
        // Value: index where that number appears
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            //Create int 'needed': The number we are looking for
            int needed = target - nums[i];

            // seen.containsKey(needed) = Have we passed this number earlier in the array?
            // If the complement already is in the map, then we found the 2 numbers
            // that add up to the target.
            if (seen.containsKey(needed)){
                return new int[] {
                    seen.get(needed), i};
                }
                
                // Store the current number and the index for future look-ups
                // We do this after checking to avoid using the same index twice.
                seen.put(nums[i], i);
            }

            // The problem guarantees one valid answer, so this should never run.
        return new int[] {};
        }      
}
