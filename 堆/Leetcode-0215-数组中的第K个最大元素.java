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
