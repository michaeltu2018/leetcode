public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(null == nums || nums.length == 0){
            return null;
        }
        int[] res = new int[nums.length];
        int t;
        if(a > 0){
            t = res.length-1;
        }
        else{
            t=0;
        }
            int start = 0;
            int end = nums.length - 1;
            int startVal = -1;
            int endVal = -1;
            while(start <= end){
                startVal = func(nums[start], a, b, c);
                endVal = func(nums[end], a, b, c);

                if(a>0){
                    if(startVal > endVal){
                        res[t] = startVal;
                        start++;
                    }
                    else{
                        res[t] = endVal;
                        end--;
                    }
                    t--;
                }
                else{
                    if(startVal < endVal){
                        res[t] = startVal;
                        start++;
                    }
                    else{
                        res[t] = endVal;
                        end--;
                    }
                    t++;
                }
            }
        

        return res;
    }
    
    int func(int x, int a, int b, int c){
        return a*x*x + b*x + c;
    }
}
