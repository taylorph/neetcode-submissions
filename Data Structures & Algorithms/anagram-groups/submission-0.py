class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # create a hashmap called result
        res = defaultdict(list) # mapping charCount to list of Anagrams

        #go through every string that we are going through in the input
        for s in strs:
            #count how many of each character it has so we will have initially an array
            count = [0] * 26 # a ... z

            #go through every single character in each string and count how many of each character
            for c in s:
                count[ord(c) - ord("a")] += 1  #subtract ascii character cuurrent (c) and subtract ascii of lowercase char "a"

            #in our result we want to add, for this first count we want to append this string s
            #so we can group all anagrams with that first particular count together
            #

            #res[count].append(s) 
            #in python, lists cannot be keys, so we have to change this to a tuple because tuple's are non-mutable
            res[tuple(count)].append(s) 

        # now that in our dictionary we have grouped the anagrams together
        # we can just take res.values, we dont want the keys anymore
        # we just want to return the values, the anagrams that are grouped together so we return that

        #return res.values() <-- will give a defaultdict obj 
        #hence convert it into a list first before returning
        return list(res.values()) 

