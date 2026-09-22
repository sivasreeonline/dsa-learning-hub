class Solution
{
    static class Node
    {
        int product;
        int[] count;

        Node(int k)
        {
            product = 1 % k;
            count = new int[k];
        }
    }

    static class SegmentTree
    {
        private final int n;
        private final int k;
        private final Node[] tree;

        SegmentTree(int[] nums, int k)
        {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];

            build(1, 0, n - 1, nums);
        }

        private Node merge(Node left, Node right)
        {
            Node result = new Node(k);

            result.product = (left.product * right.product) % k;

            for (int r = 0; r < k; r++)
            {
                result.count[r] = left.count[r];
            }

            for (int r = 0; r < k; r++)
            {
                int newRemainder = (left.product * r) % k;
                result.count[newRemainder] += right.count[r];
            }

            return result;
        }

        private void build(int node, int left, int right, int[] nums)
        {
            if (left == right)
            {
                int remainder = nums[left] % k;

                tree[node] = new Node(k);
                tree[node].product = remainder;
                tree[node].count[remainder] = 1;

                return;
            }

            int mid = left + (right - left) / 2;

            build(node * 2, left, mid, nums);
            build(node * 2 + 1, mid + 1, right, nums);

            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }

        private void update(int node, int left, int right, int index, int value)
        {
            if (left == right)
            {
                int remainder = value % k;

                tree[node] = new Node(k);
                tree[node].product = remainder;
                tree[node].count[remainder] = 1;

                return;
            }

            int mid = left + (right - left) / 2;

            if (index <= mid)
            {
                update(node * 2, left, mid, index, value);
            }
            else
            {
                update(node * 2 + 1, mid + 1, right, index, value);
            }

            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }

        private Node query(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight)
        {
            if (queryLeft <= left && right <= queryRight)
            {
                return tree[node];
            }

            int mid = left + (right - left) / 2;

            if (queryRight <= mid)
            {
                return query(
                    node * 2,
                    left,
                    mid,
                    queryLeft,
                    queryRight);
            }

            if (queryLeft > mid)
            {
                return query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    queryLeft,
                    queryRight);
            }

            Node leftResult = query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight);

            Node rightResult = query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight);

            return merge(leftResult, rightResult);
        }

        void update(int index, int value)
        {
            update(1, 0, n - 1, index, value);
        }

        Node query(int left, int right)
        {
            return query(1, 0, n - 1, left, right);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries)
    {
        SegmentTree tree = new SegmentTree(nums, k);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++)
        {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            tree.update(index, value);

            Node result = tree.query(start, nums.length - 1);
            answer[i] = result.count[x];
        }

        return answer;
    }
}