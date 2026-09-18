class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (low < high) {

            if (nums[low] != nums[low + 1]) {
                return nums[low];
            }

            low = low + 2;
        }

        return nums[n - 1];
    }
}