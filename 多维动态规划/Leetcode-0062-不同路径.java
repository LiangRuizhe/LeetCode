//二维数组动态规划：状态转移方程：f(i,j)=f(i−1,j)+f(i,j−1)
//边界条件:f(0,j) = f(i,0) = 1
class Solution {
    public int uniquePaths(int m, int n) {
        int[] f = new int [n];
        for(int i=0;i<n;i++){
            f[i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                  f[j]+= f[j-1];
            }
        }
        return f[n-1];
    }
}
