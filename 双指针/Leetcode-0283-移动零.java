//双指针，右指针每次向右移动，如果右指针不为零，则赋值到左指针的位置。第一个循环结束后，左指针左侧全为为零数字，左指针右侧到右指针全部赋值为0
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left =0;
        int right =0;
        for(;right<nums.length;right++){
            if(nums[right]!=0){
                nums[left] = nums[right];
                left++;
            }
        }
        for(int i = left;i<right;i++){
            nums[i]=0;
        }
    }
}
