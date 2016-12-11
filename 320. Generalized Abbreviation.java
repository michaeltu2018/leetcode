public class Solution {
    List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<String>();
        int n = word.length();
        res.add(n==0 ? "" : String.valueOf(n));
        for(int i=0;i<n;i++){
            List<String> rights = generateAbbreviations(word.substring(i+1));
            for(String right : rights){
                String leftNum = i > 0 ? String.valueOf(i) : "";
                res.add(leftNum + word.substring(i,i+1) + right);
            }
        }
        return res;
    }
}


// add cache to speed up: 30 ms
public class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> generateAbbreviations(String word) {
        if(map.containsKey(word)){
            return map.get(word);
        }
        List<String> res = new ArrayList<>();
        int len = word.length();
        res.add(len==0 ? "" : String.valueOf(len));
        for(int i=0;i<len;i++){
            List<String> rights;
            if(map.containsKey(word.substring(i+1))){
                rights = map.get(word.substring(i+1));
            }
            else{
                rights = generateAbbreviations(word.substring(i+1));
            }
            
            for(String s : rights){
                String leftNum = i>0?Integer.toString(i):"";
                res.add(leftNum + word.substring(i,i+1) + s);
            }
        }
        map.put(word, res);
        return res;
    }
}
