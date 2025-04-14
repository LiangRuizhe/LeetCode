class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int first=0,second=0,third=0;
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(first=0;first<len;first++){
          if(first>0&&nums[first]==nums[first-1]){
            continue;
          }//相同数字跳过
          for(second=first+1;second<len;second++){
            if (second>first+1&&nums[second]==nums[second-1]) {
                     continue;
            }//相同数字跳过
            third = len-1;
            while(second<third&&nums[first]+nums[second]+nums[third]>0)
            third--;
            if(second==third)
            break;//如果二三指针重合则退出循环
            if(nums[first]+nums[second]+nums[third]==0){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[first]);
                temp.add(nums[second]);
                temp.add(nums[third]);
                ans.add(temp);
            }
          }
        }
        return ans;
    }
}
