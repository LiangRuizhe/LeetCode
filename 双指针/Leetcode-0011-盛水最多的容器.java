//左指针为左侧模板，右指针为右侧模板，area记录可能成为答案的区域，左右指针向中间靠近时，只有height大于当前边界才有可能成为答案
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            ans = Math.max(area,ans);
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
