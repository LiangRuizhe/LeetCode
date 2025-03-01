//双指针进行遍历，height[left]<=height[right],保证至少有一个rightmax右侧比当前的左侧大，即ans+=leftmax - height[left]是合理的。
//维护两个指针 left 和 right，以及两个变量 leftMax 和 rightMax，初始时 left=0,right=n−1,leftMax=0,rightMax=0。指针 left 只会向右移动，指针 right 只会向左移动，在移动指针的过程中维护两个变量 leftMax 和 rightMax 的值。
//如果 height[left]<height[right]，则必有 leftMax<rightMax，下标 left 处能接的雨水量等于 leftMax−height[left]，将下标 left 处能接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位）


class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left =0,right =height.length-1;
        int leftmax = 0;
        int rightmax = 0;
        while(left<right){
            leftmax = Math.max(leftmax,height[left]);
            rightmax = Math.max(rightmax,height[right]);
            if(height[left] <= height[right]){
                ans+=leftmax - height[left];
                left++;
            }else{
                ans+=rightmax - height[right];
                right--;
            }
        }
         return ans;
    }
}
