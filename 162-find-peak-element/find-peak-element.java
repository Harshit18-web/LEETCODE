class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length ; 
        int low = 0 ; 
        int high = n-1 ; 
        while(low<high){
            if(nums[low]<nums[low+1]){
                low = low + 1 ; 
            }
            else{
                return low ; 
            }
        }
        return n-1;  
        
    }
}