//状态转移方程：P(i,j)=P(i+1,j−1)∧(Si​==Sj​)
//边界条件：单个字符的字符串一定是回文子串，两个字符的字符串只要两个字符相等也是字符串
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
        return s;

        int maxLen = 1;
        int begin =0;
        boolean[][] dp =  new boolean[len][len];
        for(int i=0;i<len;i++)
        dp[i][i]=true;

        char[] charArray  =s.toCharArray();
        for(int L=2;L<=len;L++){
            for(int i=0;i< len;i++){
                int j = L + i -1;
                if(j>=len)
                break;
            

            if(charArray[i]!=charArray[j])
            dp[i][j] = false;
            else{
                if(j-i<3)
                dp[i][j]=true;
                else
                dp[i][j] = dp[i+1][j-1];
            }
            
            if(dp[i][j] && j -i +1 > maxLen){
                maxLen = j - i + 1;
                begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
}
