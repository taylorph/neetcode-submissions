class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        /*
         * STEP 1:
         * Count how many times each number appears.
         *
         * HashMap structure:
         * key   = number from nums
         * value = frequency/count of that number
         *
         * Example:
         * nums = [1,1,1,2,2,3]
         *
         * count becomes:
         * 1 -> 3
         * 2 -> 2
         * 3 -> 1
         */
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        /*
         * STEP 2:
         * Create buckets where the index represents frequency.
         *
         * Why nums.length + 1?
         *
         * The highest possible frequency is nums.length.
         * Example:
         * nums = [5,5,5,5]
         * 5 appears 4 times.
         *
         * So we need indexes from 0 to nums.length.
         *
         * bucket[1] = numbers that appear 1 time
         * bucket[2] = numbers that appear 2 times
         * bucket[3] = numbers that appear 3 times
         *
         * We use List<Integer>[] because multiple numbers can have the same frequency.
         */
        List<Integer>[] bucket = new List[nums.length + 1];

        /*
         * Initialize each bucket as an empty ArrayList.
         *
         * Without this, bucket[i] would be null,
         * and calling bucket[i].add(...) would cause an error.
         */
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        /*
         * STEP 3:
         * Place each number into the bucket matching its frequency.
         *
         * Example:
         * count:
         * 1 -> 3
         * 2 -> 2
         * 3 -> 1
         *
         * bucket[3] = [1]
         * bucket[2] = [2]
         * bucket[1] = [3]
         */
        for (int num : count.keySet()) {
            int frequency = count.get(num);
            bucket[frequency].add(num);
        }

        /*
         * STEP 4:
         * Build the result by checking buckets from highest frequency to lowest.
         *
         * We start at bucket.length - 1 because that is the highest possible frequency.
         * Then we move backward toward 1.
         *
         * The first numbers we find are the most frequent.
         */
        int[] result = new int[k];
        int index = 0;

        for (int frequency = bucket.length - 1; frequency >= 0; frequency--) {

            for (int num : bucket[frequency]) {
                result[index] = num;
                index++;

                /*
                 * Once we have k numbers, we are done.
                 */
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}