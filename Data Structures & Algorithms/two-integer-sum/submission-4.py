class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Basically every element that comes before the current.
        # - Mapping the value to the index of that value
        prevMap = {} # val: index

        # Let's iterate through every value in this array
        # We need the index as well as the actual number
        for i, n in enumerate(nums):
            # Before we add anything to our map let's add 'diff' to our map:
            diff = target - n
            # - Check if the difference is already in the hashmap.
            if diff in prevMap:
                return[prevMap[diff], i]
            # If we don't find the solution we have to update our hashmap
            prevMap[n] = i
        return
