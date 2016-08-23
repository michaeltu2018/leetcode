public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                continue;
            }
            if(s.charAt(i) == '+'){
                String t = s.substring(0,i)+"--"+s.substring(i+2);
                res.add(t);
            }
        }
        
        return res;
    }
}
