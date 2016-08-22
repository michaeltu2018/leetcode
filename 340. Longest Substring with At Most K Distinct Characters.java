public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0){
            return 0;
        }
        if(s.length() <= k){
            return s.length();
        }
        int start = 0;
        int end = -1;
        int max = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) || map.size() < k){
                map.put(s.charAt(i),i);
                end = i;
            }
            else{
                int newLen = end -start+1;
                if(newLen > max){
                    max = newLen;
                }
                int minIndex = -1; 
                Character x = null;
                for(Character e: map.keySet()){
                    if(minIndex == -1){
                        minIndex = map.get(e);
                        x = e;
                    }
                    else{
                        if(map.get(e) > minIndex){
                            continue;
                        }
                        else{
                            minIndex = map.get(e);
                            x = e;
                        }
                    }
                }
                map.remove(x);
                start = minIndex+1;
                end = i;
                newLen = end - start+1;
                if(newLen > max){
                    max = newLen;
                }
                map.put(s.charAt(i),i);
            }
        }
        max = Math.max(end - start+1, max);
        return max;
    }
}
