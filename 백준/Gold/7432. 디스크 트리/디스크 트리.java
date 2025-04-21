import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static StringBuilder sb = new StringBuilder();

    // 디렉토리 트리의 각 노드를 정의
    static class Node {
        Map<String, Node> children = new TreeMap<>(); // 자동 사전순 정렬
    }

    static class Trie {
        Node root = new Node();

        // 경로 삽입: WIN\System32\config → ["WIN", "System32", "config"]
        public void insert(String path) {
            String[] parts = path.split("\\\\"); // '\'는 이스케이프 처리 필요
            Node cur = root;
            for (String part : parts) {
                cur = cur.children.computeIfAbsent(part, k -> new Node()); // 없으면 새로 생성
            }
        }

        // 계층적으로 출력: depth만큼 공백 주고 정렬된 children 순회
        public void print(Node node, int depth) {
            for (String name : node.children.keySet()) {
                for (int i = 0; i < depth; i++) sb.append(" ");
                sb.append(name).append("\n");
                print(node.children.get(name), depth + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            String path = br.readLine();
            trie.insert(path);
        }

        trie.print(trie.root, 0);
        System.out.print(sb);
    }
}
