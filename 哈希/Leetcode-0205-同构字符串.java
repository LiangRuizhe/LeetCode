//建立一个从字符串s到字符串t的双向映射，如果对应位置上的字符schar和tchar不存在于这个双向映射中则返回false
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if((s2t.containsKey(schar) && s2t.get(schar)!=tchar)||(t2s.containsKey(tchar)&&t2s.get(tchar)!=schar)){
                return false;
            }
            s2t.put(schar,tchar);
            t2s.put(tchar,schar);
        }
        return true;
        }
}
