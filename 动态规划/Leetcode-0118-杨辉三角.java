//状态转移方程：f[i][j] = f[i-1][j-1]+f[i-1][j]
//边界条件：首项和末项都为1
class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> c = new ArrayList<>(numRows);
       c.add(List.of(1));
       for(int i=1;i<numRows;i++){
        List<Integer> row = new ArrayList<>(i+1);
        row.add(1);
        for(int j=1;j<i;j++){
            row.add(c.get(i-1).get(j-1)+c.get(i-1).get(j));
        }
        row.add(1);
        c.add(row);
       }
       return c;
    }
}
