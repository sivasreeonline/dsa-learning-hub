class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // increasing cyclic
        int breaks = 0;
        int pos = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                breaks++;
                pos = (i + 1) % n;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (breaks == 1 || (breaks == 0 && nums[0] == 0)) {
            int k = (breaks == 0) ? 0 : pos;

            ans = Math.min(ans, k);
            ans = Math.min(ans, n - k + 2);
        }

        // decreasing cyclic
        breaks = 0;
        pos = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[(i + 1) % n]) {
                breaks++;
                pos = (i + 1) % n;
            }
        }

        if (breaks == 1 || (breaks == 0 && nums[0] == n - 1)) {
            int k = (breaks == 0) ? 0 : pos;

            ans = Math.min(ans, 1 + k);
            ans = Math.min(ans, 1 + (n - k));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}