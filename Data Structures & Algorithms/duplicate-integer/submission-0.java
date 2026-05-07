/*Contains Duplicate:
Given an integer array nums, 
return true if any value appears more than once in the array, 
otherwise return false.
*/

/*
This is a Hash Set / Duplicate Detection problem.

The key pattern:

"When I need to know whether I
have already seen a value before,
I should think about using a HashSet."

A HashSet is useful because it stores unique values only.
Why this is optimal:

We only scan the array once.
Each lookup and insertion in a HashSet is O(1) on average.
That gives us linear time.
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Stores each number we have already visited while scanning the array
        HashSet<Integer> seen = new HashSet<>();

        // Check each number one at a time
        for (int num : nums){
            // If the number is already in the set, we found a duplicate.
            if (seen.contains(num)){
                return true;
            }

            // Otherwise, remember this number for future duplicate checks.
            seen.add(num);
        }
        // If we finish the loop, that means every number was unique.
        return false;
    }

}