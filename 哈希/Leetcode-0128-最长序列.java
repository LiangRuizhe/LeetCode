//对于一个数nums[i]，只有set中不存在nums[i-1]的值，这个数nums[i]才有可能成为最长序列的开头
//然后循环查找是否包含nums[i]+1，记录最长序列的长度
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            ans.add(nums[i]);
        }
        int len = 0;
        for(int num : ans){ //注意第二次遍历要用去重的set数组，而不是使用原有数组nums否则会超时
            if(!ans.contains(num-1))
              {
                int cur = num;
                int curlen =1;
                while(ans.contains(cur+1)){
                    curlen++;
                    cur++;
                } 
               len = Math.max(curlen,len);
              }
        }
        return len;
    }
}
