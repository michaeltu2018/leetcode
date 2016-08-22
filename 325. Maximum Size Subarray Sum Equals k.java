public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum == k){
                count = Math.max(i+1,count);
            }
            else if(map.containsKey(sum - k)){
                 count = Math.max(i-map.get(sum-k),count);
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            
        }
        return count;
    }
}
