class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = {0, 0};
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            for(int j=(i+1); j<nums.length; j++){
                if(nums[j] == diff){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }
}