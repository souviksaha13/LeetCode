class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length; 
        int lo = 0, hi = n-1;

        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(letters[mid] <= target) lo = mid+1;
            else hi = mid-1;
        }

        if(lo == n) return letters[0];
        return letters[lo];
    }
}