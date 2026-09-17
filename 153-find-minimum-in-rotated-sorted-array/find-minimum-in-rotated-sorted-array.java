class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        int count = 0;

        while (low < high) {

            if (nums[low] < nums[low + 1]) {
                count++;
                low++;
            } 
            else {
                break;
            }
        }

        if (low == high) {
            return nums[0];
        }

        return nums[low + 1];
    }
}