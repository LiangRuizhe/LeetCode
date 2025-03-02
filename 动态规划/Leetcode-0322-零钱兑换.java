//dp[i]表示凑成金额为i最少需要的硬币数量
//状态转移方程：dp[i] = 1+dp[i-coins[j]]+1
//边界条件: dp[0]=0
class Solution {
    public int coinChange(int[] coins, int amount) {
       int max = amount+1;
       int []dp = new int [amount+1];
       Arrays.fill(dp,max);
       dp[0]=0;
       for(int i=1;i<=amount;i++)
       for(int j=0;j<coins.length;j++){
        if(coins[j]<=i){
            dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
        }
       }
       return dp[amount] > amount ? -1 : dp[amount];  
    }
}
