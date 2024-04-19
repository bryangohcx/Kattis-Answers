import java.util.*;

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

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        List<List<int[]>> edges = new ArrayList<>();
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<int[]> edgeList = new ArrayList<>();
                for (int k = 0; k < 4; k++) {
                    int ik = i + x[k];
                    int jk = j + y[k];
                    if (ik >= 0 && ik < n && jk >= 0 && jk < m) {
                        edgeList.add(new int[]{Math.max(0, arr[ik][jk] - arr[i][j]), i * m + j, ik * m + jk});
                    }
                }
                edges.add(edgeList);
            }
        }

        int ladder = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        UFDS ufds = new UFDS(n * m);
        boolean[] inPq = new boolean[n * m];

        for (int[] i : edges.get(0)) {
            pq.add(i);
        }
        inPq[0] = true;

        while (!pq.isEmpty()) {
            int[] front = pq.poll();
            int u = front[1];
            int v = front[2];

            if (!ufds.isSameSet(u, v)) {
                ufds.join(u, v);
                ladder = Math.max(ladder, front[0]);

                if (inPq[u]) {
                    for (int[] j : edges.get(v)) {
                        pq.add(j);
                    }
                } else {
                    for (int[] j : edges.get(u)) {
                        pq.add(j);
                    }
                }

                inPq[v] = true;
                inPq[u] = true;

                if (Math.max(u, v) == n * m - 1) {
                    break;
                }
            }
        }

        System.out.println(ladder);
    }
}
