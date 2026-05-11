
class Solution{
    public int[] topKFrequent(int[] nums, int k){
        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        // Index = Frequency
        // Value = List of numbers with that frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for(int num : count.keySet()){
            int freq = count.get(num);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // Step 3: Walk buckets from highest frequency to lowest
        int[] result = new int[k];
        int index = 0;

        for(int freq = buckets.length - 1; freq >= 0; freq--){
            if(buckets[freq] != null){
                for (int num : buckets[freq]){
                    result[index] = num;
                    index++;

                    if(index == k){
                        return result;
                    }
                }
            }
        }

        return result;

    }
}