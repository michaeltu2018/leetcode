public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> getFactors(int n) {
        helper(new ArrayList<Integer>(), n, 2);
        return res;
    }
    
    void helper(List<Integer> list, int n, int cur){
        if(n == 1){
            if(list.size()>1){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i=cur;i<=Math.sqrt(n);i++){
            /*
            the following code is not necessary, coz last element in list is always smaller than or equal to cur.
            if(list.size() >= 1 && list.get(list.size()-1) > i){
                continue;
            }
            */
            if(n%i==0){
                list.add(i);
                helper(list,n/i,i);
                list.remove(list.size()-1);
            }
        }
        int i = n; 
        list.add(i);
        helper(list,n/i,i);
        list.remove(list.size()-1);
    }
}
