//维护一个大小为K的小顶堆，时间复杂度O(nlogk)
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(i<k)
            minHeap.offer(nums[i]);
            else{
                Integer topElement = minHeap.peek();
                if(nums[i]>topElement){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}
//快速排序，三路划分
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
      List<Integer> ans = new ArrayList<>();
      for(int i=0;i<nums.length;i++){
        ans.add(nums[i]);
      }
      return QuickSelect(ans, k);
        
    }
    public int QuickSelect(List<Integer> nums,int k){
        Random ran = new Random();
        int pivot = nums.get(ran.nextInt(nums.size()));
        List<Integer> bigger = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        for(int num:nums){
            if(num>pivot)
            bigger.add(num);
            else if(num<pivot)
            smaller.add(num);
            else
             equal.add(num);
        }
        if(k<=bigger.size())
        return QuickSelect(bigger, k);//注意判断bigger的边界条件
        if(nums.size()-smaller.size()<k){
        return QuickSelect(smaller, k - nums.size() + smaller.size());
        }
        return pivot;
    }
}
