import java.util.*;

public class millionairemadness {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int width = sc.nextInt();
        int[][] vault = new int[length][width];

        // Reading the height of each pile of coins
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                vault[i][j] = sc.nextInt();
            }
        }

        // Using Dijkstra's algorithm to find the minimum ladder length
        int minLadderLength = dijkstra(vault, length, width);
        System.out.println(minLadderLength);
    }

    private static int dijkstra(int[][] vault, int length, int width) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.maxStep));
        boolean[][] visited = new boolean[length][width];
        pq.offer(new Cell(0, 0, 0));

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            if (visited[current.x][current.y]) {
                continue;
            }
            visited[current.x][current.y] = true;

            if (current.x == length - 1 && current.y == width - 1) {
                return current.maxStep;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < length && ny >= 0 && ny < width && !visited[nx][ny]) {
                    int newStep = vault[nx][ny] - vault[current.x][current.y];
                    if (newStep > 0) { // Need a ladder to climb up
                        pq.offer(new Cell(nx, ny, Math.max(current.maxStep, newStep)));
                    } else { // No ladder needed to step down or move to the same height
                        pq.offer(new Cell(nx, ny, current.maxStep));
                    }
                }
            }
        }
        return -1;
    }

    static class Cell {
        int x, y, maxStep;

        Cell(int x, int y, int maxStep) {
            this.x = x;
            this.y = y;
            this.maxStep = maxStep;
        }
    }
}
