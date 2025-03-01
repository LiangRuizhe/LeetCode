//双指针字符串，从左右往中间靠近
class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int left =0;
        int right = n-1;
        while(left<right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
