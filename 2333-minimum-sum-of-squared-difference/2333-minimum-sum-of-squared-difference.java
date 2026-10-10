class Solution
{
    public long minSumSquareDiff(
        int[] nums1,
        int[] nums2,
        int k1,
        int k2)
    {
        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        long total = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++)
        {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        if (total <= k)
        {
            return 0;
        }

        int left = 0;
        int right = maxDiff;

        while (left < right)
        {
            int mid = left + (right - left) / 2;
            long needed = 0;

            for (int d : diff)
            {
                if (d > mid)
                {
                    needed += d - mid;
                }
            }

            if (needed <= k)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }

        int cap = left;
        long used = 0;
        long sumSquares = 0;

        for (int d : diff)
        {
            int reduced = Math.min(d, cap);

            used += d - reduced;
            sumSquares += (long) reduced * reduced;
        }

        long remaining = k - used;

        sumSquares -= remaining * (2L * cap - 1);

        return sumSquares;
    }
}