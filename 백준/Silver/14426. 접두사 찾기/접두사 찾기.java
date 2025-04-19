import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		Node[] children;
		boolean isEndOfNumber;
		boolean isExist;

		public Node() {
			this.children = new Node[26];
			this.isEndOfNumber = false;
			this.isExist = false;
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
				int digit = num.charAt(i) - 'a';

				if (cur.children[digit] == null) {
					cur.children[digit] = new Node();
				}
				cur = cur.children[digit];
				cur.isExist = true;
			}
			cur.isEndOfNumber = true;
		}

		private boolean getNode(String str) {
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				int digit = str.charAt(i) - 'a';
				if (cur.children[digit] == null)
					return false;
				cur = cur.children[digit];
			}
			return cur.isExist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			trie.insert(tmp);
		}
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (trie.getNode(tmp)) {
				answer++;
			}
		}

		System.out.println(answer);

	}

}