//dp[i]数组表示从第0位到第i位的最长子序列（必须包含第i位）的和
//状态转移方程：dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
//边界条件：dp[0]=1
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int []dp = new int [nums.length];
        dp[0] = 1;
        int maxans =1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }
}
