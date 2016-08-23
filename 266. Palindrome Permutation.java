public class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] c = new char[256];
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(c[s.charAt(i)] > 0){
                c[s.charAt(i)]--;
            }
            else if(c[s.charAt(i)] <= 0){
                c[s.charAt(i)]++;
            }
        }
        for(int i=0; i<256; i++){
            if(c[i]!=0)count++;
        }
        return count <= 1;
    }
}
