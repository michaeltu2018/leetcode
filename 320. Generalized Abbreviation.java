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

