public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length <= 2){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]*3 >= target){break;}
            int diff = target - nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                if(nums[l] + nums[r] < diff){
                    count+= r-l;
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return count;
    }
}
