class UFDS {
    private int[] parent;

    public UFDS(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int n) {
        return n == parent[n] ? n : (parent[n] = find(parent[n]));
    }

    public boolean isSameSet(int n, int m) {
        return find(n) == find(m);
    }

    public void join(int n, int m) {
        parent[find(n)] = find(m);
    }
}