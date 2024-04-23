import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;

public class dominos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            int count = 0;
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            List<Integer>[] AdjL = new LinkedList[n];
            boolean[] visited = new boolean[n];
            Stack<Integer> order = new Stack<>();
            for (int j = 0; j < n; j++) {
                AdjL[j] = new LinkedList<>();
            }
            for (int j = 0; j < m; j++) {
                line = br.readLine().split(" ");
                int knock = Integer.parseInt(line[0]) - 1;
                int knocked = Integer.parseInt(line[1]) - 1;
                AdjL[knock].add(knocked);
            }
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    arrange(j, AdjL, visited, order);
                }
            }
            // Reset visited array for the second DFS
            for (int j = 0; j < n; j++) {
                visited[j] = false;
            }
            while (!order.empty()) {
                int j = order.pop();
                if (!visited[j]) {
                    count++;
                    topple(j, AdjL, visited);
                }
            }
            System.out.println(count);
        }
        br.close();
    }

    public static void topple(int j, List<Integer>[] AdjL, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(j);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                for (int next : AdjL[current]) {
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }

    public static void arrange(int j, List<Integer>[] AdjL, boolean[] visited, Stack<Integer> order) {
        Stack<Integer> stack = new Stack<>();
        stack.push(j);
        while (!stack.isEmpty()) {
            int current = stack.peek();
            if (!visited[current]) {
                visited[current] = true;
                for (int next : AdjL[current]) {
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            } else {
                stack.pop();
                order.push(current);
            }
        }
    }
}
