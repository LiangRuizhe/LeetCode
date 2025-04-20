class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i=0;//检查的加油站数量，开始循环的加油站index
        int n=gas.length;
        while(i<n){
            int sumOfCost = 0;
            int sumOfGas = 0;
            int count = 0;
            while(count < n){
                int j = (i+count)%n;
                sumOfCost +=cost[j];
                sumOfGas +=gas[j];
                if(sumOfCost>sumOfGas)
                break;
                count++;
            }
            if(count==n)
            return i;
            else{
                i = i+count+1;
            }  
        }
        return -1;
    }
}
