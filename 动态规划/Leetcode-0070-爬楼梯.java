//动态规划+滚动数组
//状态转移方程：f(x)=f(x−1)+f(x−2)，边界条件，f(0)=0;f(1)=1;f(2)=2;
//滚动数组：p=0,q=0,r0=1;
class Solution {
    public int climbStairs(int n) {
        int p=0,q=0,r=1;
        for(int i=1;i<=n;i++){
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }
}
