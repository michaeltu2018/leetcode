public class Solution {
    public boolean isStrobogrammatic(String num) {
        int l = 0;
        int r = num.length() - 1;
        while(l < r){
            if(!isMatch(num.charAt(l),num.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        if(l>r || (l==r && (num.charAt(l) == '0' || num.charAt(l) == '1' ) || num.charAt(l) == '8')){
            return true;
        }
        return false;
    }
    
    boolean isMatch(char a, char b){
        if((a == '8' && b == '8') ||
           (a == '1' && b == '1') ||
           (a == '0' && b == '0') ||
           (a == '6' && b == '9') ||
           (a == '9' && b == '6')){
               return true;
           }
        return false;
    }
    
}
