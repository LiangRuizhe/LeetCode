//状态转移方程：f[i] = 1 + min(f[i-j*j]) 
//边界调节:f[0] = 0
class Solution {
    public int numSquares(int n) {
        int []ans = new int[n+1];
        ans[0]=0;
        for(int i=1;i<=n;i++){
            int minn=5;
            for(int j=1;j*j<=i;j++){
                minn=Math.min(minn,ans[i-j*j]);
            }
            ans[i]=minn+1;
        }
        return ans[n];
    }
}
