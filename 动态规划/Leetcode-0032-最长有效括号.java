//dp[i] 表示以下标 i 字符结尾的最长有效括号的长度
//状态转移方程：s[i]=‘)’ 且 s[i−1]=‘(’时，dp[i]=dp[i−2]+2
//如果s[i]=‘)’ 且 s[i−1]=‘)’，则 dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int []dp = new int[s.length()];
        for(int i=1;i<s.length();++i){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                }             
            else if( i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1)=='('){
                  dp[i] = dp[i-1] + ((i-dp[i-1])>=2?dp[i-dp[i-1]-2] : 0) +2;
            }
            maxans = Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }
}
