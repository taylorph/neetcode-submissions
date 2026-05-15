class Solution {
    public int maxArea(int[] height){
        // res stores the largest water area
        int res = 0;
        // left pointer starts at beginning
        int l = 0;
        // right pointer starts at end
        int r = height.length -1;

        // keep checking containers while left is before right
        while(l < r){
            int width = r - l; // distance between the 2 heights
            int containerHeight = Math.min(height[l], height[r]); // height = the shorter of the 2 lines
            int area = width * containerHeight;
            res = Math.max(res, area);

            // move the pointer with the smaller height
            if(height[l] < height[r]){
                l++;
                }else{
                    r--;
                }
            }
            return res;
        }
    }
