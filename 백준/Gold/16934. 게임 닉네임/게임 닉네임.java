import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static class Node {
		Node[] children;
		boolean isExist;
		int endCnt;

		public Node() {
			this.children = new Node[26];
			this.isExist = false;
			this.endCnt = 1;
		}
	}

	static class Trie {
		Node root;

		public Trie() {
			root = new Node();
		}

		public void insert(String num) {
			boolean stopW = false;
			Node cur = root;

			for (int i = 0; i < num.length(); i++) {
				int digit = num.charAt(i) - 'a';
				if (!stopW) {
					sb.append(String.valueOf(num.charAt(i)));
				}
				if (cur.children[digit] == null) {
					cur.children[digit] = new Node();
					stopW = true;
				}
				cur = cur.children[digit];
				cur.isExist = true;
			}
			if (cur.endCnt > 1) {
				sb.append(cur.endCnt);
			}
			cur.endCnt++;
			sb.append("\n");
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			trie.insert(tmp);
		}
		System.out.println(sb);

	}

}