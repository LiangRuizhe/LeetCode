//由于nums存在正负，所以乘积最大值可能由前面数组的最大值乘上nums[i](nums[i]>0)或者前面乘积的最小值乘上nums[i](nums[i]<0)得到
//状态转移方程：nums[i]>0 maxF[i]= maxF[i-1]*nums[i]; minF[i]  = minF[i-1]*nums[i],nums<0,则讨论情况相反
//边界条件,maxF[0] = minF[0]=nums[0]
class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF =new long[length];
        long[] minF =new long[length];
        for(int i=0;i<length;i++){
                 maxF[i]=nums[i];
                 minF[i]=nums[i];
        }
        for(int i=1;i<length;i++){
            if(nums[i]>=0){
                maxF[i]=Math.max(maxF[i-1]*nums[i],nums[i]);
                minF[i]=Math.min(minF[i-1]*nums[i],nums[i]);
            }else{
                maxF[i]=Math.max(minF[i-1]*nums[i],nums[i]);
                minF[i]=Math.min(maxF[i-1]*nums[i],nums[i]);
            }
            
            
        }
        int ans = (int) maxF[0];
        for(int i=1;i<length;i++){
            ans = Math.max(ans,(int)maxF[i]);
        }
        return ans;
    }
}
