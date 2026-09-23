class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //using binary search
        int low = 1;
        int high = 0;
        for(int i = 0 ;i<nums.length; i++){
            high = Math.max(high, nums[i]);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int sum = 0;
            for(int i=0; i<nums.length; i++){
                int div = nums[i]/mid;
                int rem = nums[i]%mid;
                if(nums[i]%mid == 0){
                    sum += div;
                }else{
                    sum += div + 1;
                }
            }
            if(sum <= threshold){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}