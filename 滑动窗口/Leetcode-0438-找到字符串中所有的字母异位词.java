//维护一个长度为p.length的滑动窗口在s中滑动，记录滑动窗口内的26个字母的出现字数数组scount和pcount（检测窗口内的字符串是否与p为异位词）
//如果两个数组相同，则为异位词，如果不同则不为异位词
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        if(sLen < pLen){
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int []sCount = new int[26];
        int []pCount = new int[26];

        for(int i=0; i<pLen; i++){
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }

        for(int i=0;i<sLen-pLen;i++){
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+pLen)-'a']++;

            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }



      //引入differ记录每次窗口滑动两个数组的差异，
      public List<Integer> findAnagrams2(String s, String p) {
 int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }//记录字符串s index 0-p.len和p的字符数差距

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  //如果窗口左侧字符只出现一次，那么对应窗口下次移动，differ－1；窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 如果窗口左侧和右侧字符相同，则先--再++，窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];
            
            if (differ == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
