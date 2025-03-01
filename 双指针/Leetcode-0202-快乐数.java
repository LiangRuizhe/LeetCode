//使用快慢指针判断成环，如果成环，则快慢指针必定相遇。
class Solution {
    public int getNext(int n){
        int totalSum = 0;
        while(n>0){
            int d = n %10;
            n  = n/10;
            totalSum+=d*d;
        }
        return totalSum;
    }
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while(fastRunner!=1 && slowRunner != fastRunner){
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner ==1;
    }
}
