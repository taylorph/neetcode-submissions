class Solution {
    // Encodes a list of strings to a single string
    public String encode(List<String> strs) {

        StringBuilder res = new StringBuilder();

        for (String s : strs){

            // Format:
            // length#word
            // Example:
            // 4#neet

            res.append(s.length())
                .append("#")
                .append(s);
        }

        return res.toString();
    }

    // Decodes a single string back into a list of strings
    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;

            //Find the "#" 
            while (str.charAt(j) != '#'){
                j++;
            }

            // get number before "#"
            int length = Integer.parseInt(str.substring(i,j));
            //Extract the word
            String word = 
                str.substring(j+1, j+1+length);

            res.add(word);

            //move i to the start of next encoded word
            i = j + 1 + length;
        }

        return res;
    }
}
