public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        helper(n,n,res);
        return res;
    }
    
    void helper(int targetLen, int n, List<String> res){
        if(n==0){
            res.add("");
            return;
        }
        if(n==1){
            res.add("0");
            res.add("8");
            res.add("1");
            return;
        }
        helper(targetLen, n-2, res);
        int size = res.size();
        int i = 0;
        while(i<size){
            String cur = res.get(i);
            if(n!=targetLen) res.add("0" + cur + "0");
            res.add("1" + cur + "1");
            res.add("8" + cur + "8");
            res.add("6" + cur + "9");
            res.add("9" + cur + "6");
            res.remove(0);
            size--;
        }
    }
}
