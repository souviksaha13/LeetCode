class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int lo = 1, hi = 1;

        while(lo < n) {
            if(nums[lo] != nums[lo-1]) break;
            else lo++;
        }

        if(lo == n) return 0;

        while(hi < n) {
            if(nums[n-1-hi] != nums[n-hi]) break;
            else hi++;
        }
        return n-lo-hi;
    }
}