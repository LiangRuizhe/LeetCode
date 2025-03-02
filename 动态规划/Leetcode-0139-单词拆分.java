//状态数组dp[i]表示字符串s的0到i位是否能有wordDict构成
//状态转移方程：p[i]=dp[j] && check(s[j..i−1])
//边界条件：dp[0] = true 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> worldDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&worldDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
