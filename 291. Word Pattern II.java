public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return helper(pattern, 0, str, 0, map, set);
    }
    
    boolean helper(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set){
        if(i == pattern.length() && j == str.length()){
            return true;
        }
        if(i == pattern.length() || j == str.length()){
            return false;
        }
        char c = pattern.charAt(i);
        if(map.containsKey(c)){
            if(!str.startsWith(map.get(c),j)){
                return false;
            }
            return helper(pattern,i+1,str,j+map.get(c).length(),map,set);
        }
        for(int k=j+1;k<=str.length();k++){
            String sub = str.substring(j,k);
            if(set.contains(sub)){
                continue;
            }
            map.put(c, sub);
            set.add(sub);
            if(helper(pattern,i+1,str,k,map,set)){
                return true;
            }
            map.remove(c);
            set.remove(sub);
        }
        return false;
    }
}
