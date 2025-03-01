//对于某一个房间的价值，只需要考虑，是由前一个房间得到（放弃掉当前房间的价值）还是上上一个个房间得到（选取本个房间和上上一个房间）
//状态转移方程： dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1);
//边界值:dp[0] = nums[0]; dp[1] = Math.max(nums[0],nums[1])
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
           return 0;
        int length = nums.length;
        if(length==1)
        return nums[0];
        int []dp=new int[length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<length;i++)
        dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        return dp[length-1];
    }
}
