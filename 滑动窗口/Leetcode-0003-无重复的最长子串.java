//维护一个滑动窗口，如果当前集合中不存在于s[right]相同的元素，则滑动窗口右端向右移动
//如果right重复，则滑动窗口向左移动，直到集合中不存在重复的元素
//记录并维护res的长度
class Solution {
    public int lengthOfLongestSubstring(String s) {
      char[] ss = s.toCharArray();
      Set<Character> set = new HashSet<>();//去重
      int res =0;
      for(int left = 0, right =0;right< s.length();right++){
     char temp = ss[right];
     while(left<=right && set.contains(temp)){
        set.remove(ss[left]);
        left++;
     }
     set.add(temp);
     res = Math.max(res,right-left+1);
       }
    return res;
    }
}
