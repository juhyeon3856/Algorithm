import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		Node[] children;
		boolean isEndOfNumber;

		public Node() {
			this.children = new Node[10];
			this.isEndOfNumber = false;
		}
	}

	static class Trie {
		Node root;

		public Trie() {
			root = new Node();
		}

		public void insert(String num) {
			Node cur = root;

			for (int i = 0; i < num.length(); i++) {
				int digit = num.charAt(i) - '0';

				if (cur.children[digit] == null) {
					cur.children[digit] = new Node();
				}
				cur = cur.children[digit];
			}
			cur.isEndOfNumber = true;
		}

		public boolean startWith(String prefix) {
			Node node = getNode(prefix);
			if (node == null)
				return false;
			for (Node next : node.children) {
				if (next != null)
					return true;
			}
			return false;

		}

		private Node getNode(String str) {
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				int digit = str.charAt(i) - '0';
				if (cur.children[digit] == null)
					return null;
				cur = cur.children[digit];
			}
			return cur;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		test: for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = new String[N];
			Trie trie = new Trie();

			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				trie.insert(tmp);
				input[i] = tmp;
			}

			for (String str : input) {
				if (trie.startWith(str)) {
					sb.append("NO\n");
					continue test;
				}
			}

			sb.append("YES\n");
		}
		System.out.println(sb);
	}
}
