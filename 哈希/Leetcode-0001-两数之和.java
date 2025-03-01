//HashMap根据键的HashCode 值存储数据,根据键可以直接获取它的值，具有很快的访问速度。HashMap最多只允许一条记录的键为Null(多条会覆盖);允许多条记录的值为 Null。非同步的。
//创建一个哈希表，对于每一个 x，首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中
//nums数组中的值nums[i]作为键，索引index作为值
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {i,map.get(target-nums[i])};
            }
         map.put(nums[i], i);   
        }
      return new int [0];
    }
}
