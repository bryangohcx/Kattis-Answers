package nicknames;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class nicknames {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> queries = new HashMap<>();
        HashMap<Character,AVL> forest = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char key = name.charAt(0);
            if (forest.containsKey(key)) {
                forest.get(key).add(name);
            } else {
                AVL tree = new AVL();
                tree.add(name);
                forest.put(key, tree);
            }
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (queries.containsKey(name)) {
                System.out.println(queries.get(name));
                continue;
            }
            Character key = name.charAt(0);
            int ans = 0;
            if(forest.containsKey(key)){
                ans = forest.get(key).query(name);
            }else{ans =0;}
                queries.put(name, ans);
                System.out.println(ans);
        }
    }
}

class Nodes {
    Nodes parent, left, right;
    String data;
    int height, size;

    Nodes(String name) {
        this.data = name;
        this.size = 1;
        this.height = 1; // Initially, height is set to 1 for a leaf node
        this.parent = this.left = this.right = null;
    }
}

class AVL {
    Nodes root;

    public AVL() {
        root = null;
    }

    public void add(String name) {
        root = addRecursive(root, name);
    }

    private Nodes addRecursive(Nodes node, String value) {
        if (node == null) {
            return new Nodes(value);
        }

        if (value.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, value);
        } else if (value.compareTo(node.data) > 0) {
            node.right = addRecursive(node.right, value);
        } else {
            // Value already exists, return node without duplication
            return node;
        }

        // Update height and size of this ancestor node
        updateHeightAndSize(node);

        // Balance the tree
        return balance(node);
    }

    private void updateHeightAndSize(Nodes node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        node.size = 1 + getSize(node.left) + getSize(node.right);
    }

    private int getHeight(Nodes node) {
        return node == null ? 0 : node.height;
    }

    private int getSize(Nodes node) {
        return node == null ? 0 : node.size;
    }

    private Nodes balance(Nodes node) {
        int balanceFactor = getBalanceFactor(node);
        // Left heavy subtree
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
        // Right heavy subtree
        if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }
        // Already balanced
        return node;
    }

    private int getBalanceFactor(Nodes node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private Nodes leftRotate(Nodes x) {
        Nodes y = x.right;
        Nodes T2 = y.left;
        y.left = x;
        x.right = T2;
        if (T2 != null) T2.parent = x;
        y.parent = x.parent;
        x.parent = y;

        updateHeightAndSize(x);
        updateHeightAndSize(y);
        
        return y;
    }

    private Nodes rightRotate(Nodes y) {
        Nodes x = y.left;
        Nodes T2 = x.right;
        x.right = y;
        y.left = T2;
        if (T2 != null) T2.parent = y;
        x.parent = y.parent;
        y.parent = x;

        updateHeightAndSize(y);
        updateHeightAndSize(x);
        
        return x;
    }

    public int query(String prefix) {
        return queryHelp(root, prefix);
    }

    private int queryHelp(Nodes node, String prefix) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.data.startsWith(prefix)) {
            count += 1;
        }
        count += queryHelp(node.left, prefix);
        count += queryHelp(node.right, prefix);
        return count;
    }
}