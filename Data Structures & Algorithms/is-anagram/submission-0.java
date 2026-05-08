class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char current = s.charAt(i);


            count.put(current, count.getOrDefault(current, 0) +1);
        }

        for (int i = 0; i < t.length(); i++){
            char current = t.charAt(i);

            if (!count.containsKey(current)){
                return false;
            }

            count.put(current, count.get(current) -1);

            if(count.get(current) < 0){
                return false;
            }
        }

        return true;
    }
}
