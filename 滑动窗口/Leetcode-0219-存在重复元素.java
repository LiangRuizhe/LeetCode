//使用滑动窗口维护一个长度为k大小的set集合,检查是否存在重复
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(i>k){
                set.remove(nums[i-1-k]);
            }
            if(set.add(nums[i])==false){
              //向set中使用add方法加入重复元素会返回false
                   return true;
            }
        }
        return false;   
    }
}
