//对于一个数nums[i]，只有set中不存在nums[i-1]的值，这个数nums[i]才有可能成为最长序列的开头
//然后循环查找是否包含nums[i]+1，记录最长序列的长度
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num : nums){
            num_set.add(num);
        }
        int ans = 0;
        for(int num : num_set){
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int temp = 1;

                while(num_set.contains(currentNum+1)){
                currentNum+=1;
                temp+=1;

            }
             ans = Math.max(ans,temp);
            }         
        }
        return ans;
    }
}
