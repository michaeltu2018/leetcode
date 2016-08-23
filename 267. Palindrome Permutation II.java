public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        int odd = 0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.containsKey(s.charAt(i))?map.get(s.charAt(i))+1:1);
            odd += (map.get(s.charAt(i))%2!=0)?1:-1;
        }
        if(odd > 1){
            return res;
        }
        String mid = "";
        List<Character> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char key = entry.getKey();
            Integer val = entry.getValue();
            if(val % 2!=0){
                mid += key;
            }
            for(int i=0;i<val/2;i++){
                list.add(key);
            }
        }
        boolean[] used = new boolean[list.size()];
        dfs(list,used,new StringBuffer(),mid,res);
        return res;
    }
    
    void dfs(List<Character> list, boolean[] used, StringBuffer sb, String mid,List<String> res){
        if(sb.length() == list.size()){
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for(int i=0;i<list.size();i++){
            if(used[i] == true) continue;
            if(i!=0 && list.get(i) == list.get(i-1) && !used[i-1]) continue;
            used[i] = true;
            sb.append(list.get(i));
            dfs(list,used,sb,mid,res);
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;
        }
    }
}
