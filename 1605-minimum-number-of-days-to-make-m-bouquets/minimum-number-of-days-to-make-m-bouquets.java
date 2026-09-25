class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        // Check if enough flowers exist
        if ((long) m * k > n) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum bloom day
        for (int bloom : bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }

        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {

                // mid works, but maybe a smaller day works
                answer = mid;
                high = mid - 1;

            } else {

                // mid doesn't work, need more days
                low = mid + 1;
            }
        }

        return answer;
    }


    private boolean canMake(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int consecutive = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                consecutive++;

                if (consecutive == k) {

                    bouquets++;
                    consecutive = 0;
                }

            } else {

                consecutive = 0;
            }
        }

        return bouquets >= m;
    }
}