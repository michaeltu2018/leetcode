public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=1;j<strings[i].length();j++){
                sb.append((char)((strings[i].charAt(j)-strings[i].charAt(j-1)+26)%26));
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(strings[i]);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                map.put(sb.toString(),list);
            }
        }
        for(String s : map.keySet()){
            List<String> list = map.get(s);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}
