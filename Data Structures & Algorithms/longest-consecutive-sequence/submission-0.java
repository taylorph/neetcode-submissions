class Solution {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();

        // Put every number into a set for O(1) lookup

        for (int num : nums) {

            numSet.add(num);

        }

        int longest = 0;

        for (int num : numSet) {

            // Only start counting if this number is the START of a sequence

            // Example: 1 is a start because 0 is not in the set

            // But 2 is not a start because 1 is in the set

            if (!numSet.contains(num - 1)) {

                int length = 1;

                int current = num;

                // Count upward: num, num+1, num+2, ...

                while (numSet.contains(current + 1)) {

                    current++;

                    length++;

                }

                longest = Math.max(longest, length);

            }

        }

        return longest;

    }

}