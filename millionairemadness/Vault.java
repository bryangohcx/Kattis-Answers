import java.util.Scanner;

public class Vault {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        long[][] satData = new long[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                satData[i][j] = sc.nextLong();
            }
        }
        sc.close();

        long result = cost(satData);
        System.out.println(result);
    }

    public static long cost(long[][] satData) {
        int r = satData.length;
        int c = satData[0].length;
        long[][] cost = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cost[i][j] = -1L;
            }
        }
        cost[0][0] = 0L;

        // Calculate cost using dynamic programming
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                long S = satData[i][j];
                long C = cost[i][j];

                if (i - 1 >= 0) {
                    cost[i][j] = Math.max(cost[i][j], Math.max(C, satData[i - 1][j] - S));
                }
                if (i + 1 < r) {
                    cost[i][j] = Math.max(cost[i][j], Math.max(C, satData[i + 1][j] - S));
                }
                if (j - 1 >= 0) {
                    cost[i][j] = Math.max(cost[i][j], Math.max(C, satData[i][j - 1] - S));
                }
                if (j + 1 < c) {
                    cost[i][j] = Math.max(cost[i][j], Math.max(C, satData[i][j + 1] - S));
                }
            }
        }

        return cost[r - 1][c - 1];
    }
}