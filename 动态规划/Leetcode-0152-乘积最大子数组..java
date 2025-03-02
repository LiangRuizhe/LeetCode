class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF =new long[length];
        long[] minF =new long[length];
        for(int i=0;i<length;i++){
                 maxF[i]=nums[i];
                 minF[i]=nums[i];
        }
        for(int i=1;i<length;i++){
            if(nums[i]>=0){
                maxF[i]=Math.max(maxF[i-1]*nums[i],nums[i]);
                minF[i]=Math.min(minF[i-1]*nums[i],nums[i]);
            }else{
                maxF[i]=Math.max(minF[i-1]*nums[i],nums[i]);
                minF[i]=Math.min(maxF[i-1]*nums[i],nums[i]);
            }
            
            
        }
        int ans = (int) maxF[0];
        for(int i=1;i<length;i++){
            ans = Math.max(ans,(int)maxF[i]);
        }
        return ans;
    }
}
