//dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j
//如果j>=num[i],即当前物品可以被选取，则状态转移方程为: dp[i][j]=dp[i-1][j]|dp[i-1][j-num];
//如果j<num[i]，即当前物品不可以被选取，则状态转移方程为: dp[i][j]=dp[i-1][j];
//边界条件: dp[i][0]=true; 对于任意下标范围内选取若干个整数，一定存在一种方案使得其和为0(全部都不选取)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2){
         return false;
        }
        int sum =0;
        int maxNum = 0;

        for(int num:nums){
            sum+=num;
            maxNum = Math.max(maxNum,num);
        }
        if(sum%2!=0)
        return false;

        int target = sum/2;
        if(maxNum > target)
        return false;
        
        boolean[][] dp =new boolean[n][target+1];
        for(int i=0;i<n;i++)
        dp[i][0]=true;
        for(int i=1;i<n;i++){
            int num = nums[i];
            for(int j=1;j<=target;j++){
                if(j>=num){
                    dp[i][j]=dp[i-1][j]|dp[i-1][j-num];
                }else{
                dp[i][j]=dp[i-1][j];
                }          
            }
        }
        return dp[n-1][target];
    }
}
