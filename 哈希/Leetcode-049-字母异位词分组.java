//互为字母异位词的两个字符串包含的字母相同,将字符串数组排序后放入HashMap中
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str:strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new  ArrayList<List<String>>(map.values());
    }
}
