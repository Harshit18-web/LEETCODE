class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // low = maximum element
        // high = sum of all elements
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {
                // mid is possible
                answer = mid;

                // Try to find a smaller maximum sum
                high = mid - 1;
            } 
            else {
                // mid is not possible
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean isPossible(int[] nums, int k, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num <= maxSum) {
                currentSum += num;
            } 
            else {
                // Start a new subarray
                subarrays++;
                currentSum = num;
            }

            // More than k subarrays needed
            if (subarrays > k) {
                return false;
            }
        }

        return true;
    }
}