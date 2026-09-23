class Solution 
{

    static class Node 
    {
        int[] remain;
        int prod;

        Node(int k) 
        {
            remain = new int[k];
            prod = 1;
        }
    }

    class SegmentTree 
    {
        int n;
        int k;
        Node[] tree;

        SegmentTree(int[] nums, int k) 
        {
            this.n = nums.length;
            this.k = k;
            tree = new Node[4 * n];

            for (int i = 0; i < 4 * n; i++) 
            {
                tree[i] = new Node(k);
            }

            build(nums, 0, 0, n - 1);
        }

        private void build(int[] nums, int idx, int l, int r) 
        {
            if (l == r) 
            {
                tree[idx].remain[nums[l]] = 1;
                tree[idx].prod = nums[l];
                return;
            }

            int mid = (l + r) / 2;

            build(nums, 2 * idx + 1, l, mid);
            build(nums, 2 * idx + 2, mid + 1, r);

            tree[idx] = merge(tree[2 * idx + 1], tree[2 * idx + 2]);
        }

        public void update(int pos, int val) 
        {
            update(0, 0, n - 1, pos, val);
        }

        private void update(int idx, int l, int r, int pos, int val) 
        {
            if (l == r) 
            {
                tree[idx] = new Node(k);
                tree[idx].remain[val] = 1;
                tree[idx].prod = val;
                return;
            }

            int mid = (l + r) / 2;

            if (pos <= mid) 
            {
                update(2 * idx + 1, l, mid, pos, val);
            } 
            else 
            {
                update(2 * idx + 2, mid + 1, r, pos, val);
            }

            tree[idx] = merge(tree[2 * idx + 1], tree[2 * idx + 2]);
        }

        public Node query(int ql, int qr) 
        {
            return query(0, 0, n - 1, ql, qr);
        }

        private Node query(int idx, int l, int r, int ql, int qr) 
        {
            if (ql <= l && r <= qr) 
            {
                return tree[idx];
            }

            if (r < ql || l > qr) 
            {
                return new Node(k);
            }

            int mid = (l + r) / 2;

            Node left = query(2 * idx + 1, l, mid, ql, qr);
            Node right = query(2 * idx + 2, mid + 1, r, ql, qr);

            return merge(left, right);
        }

        private Node merge(Node left, Node right) 
        {
            Node res = new Node(k);

            res.prod = (left.prod * right.prod) % k;

            for (int i = 0; i < k; i++) 
            {
                res.remain[i] = left.remain[i];
            }

            for (int i = 0; i < k; i++) 
            {
                res.remain[(i * left.prod) % k] += right.remain[i];
            }

            return res;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) 
    {

        for (int i = 0; i < nums.length; i++) 
        {
            nums[i] %= k;
        }

        for (int[] q : queries) 
        {
            q[1] %= k;
        }

        SegmentTree st = new SegmentTree(nums, k);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) 
        {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            st.update(index, value);

            Node res = st.query(start, nums.length - 1);

            ans[i] = res.remain[x];
        }

        return ans;
    }
}