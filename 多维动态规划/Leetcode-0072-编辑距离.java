//D[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离
//状态转移方程:若 A 和 B 的最后一个字母相同：
//D[i][j]​=min(D[i][j−1]+1,D[i−1][j]+1,D[i−1][j−1])
//如果不同：D[i][j]=1+min(D[i][j−1],D[i−1][j],D[i−1][j−1])

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n*m==0)
        return n+m;

        int [][]D = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            D[i][0]=i;
        }

        for(int j=0;j<m+1;j++){
            D[0][j]=j;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                int left = D[i-1][j];
                int down = D[i][j-1];
                int left_down = D[i-1][j-1];
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                     D[i][j]= Math.min(left+1,Math.min(down+1,left_down));
                }else{
                     D[i][j]=Math.min(left,Math.min(down,left_down))+1;
                }
            }          
        } 
        return D[n][m];
    }
}
