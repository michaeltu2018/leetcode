public class Solution {
    public String rearrangeString(String str, int k) {
        int length = str.length();
        if(0 == length){
            return "";
        }
        int[] counts = new int[26];
        int[] valid = new int[26];
        for(int i=0;i<length;i++){
            counts[str.charAt(i)-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int pos = getCandidate(counts, valid,i);
            if(pos == -1){
                return "";
            }
            counts[pos]--;
            valid[pos] = i+k;
            sb.append((char)('a' + pos));
        }
        return sb.toString();
    }
    
    int getCandidate(int[] counts, int[] valid, int index){
        int pos = -1;
        int maxCount = -1;
        for(int i=0;i<counts.length;i++){
            if(counts[i] > 0 && counts[i] > maxCount && valid[i] <= index){
                maxCount = counts[i];
                pos = i;
            }
        }
        return pos;
    }
}
