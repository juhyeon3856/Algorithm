import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int N;
	static Map<Character, Character[]> tree;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.put(st.nextToken().charAt(0), new Character[] { st.nextToken().charAt(0), st.nextToken().charAt(0) });
		}
//		System.out.println(tree);
//		for(Character k:tree.keySet()) {
//			System.out.println(tree.get(k)[0] + ", " + tree.get(k)[1]);
//		}
		

		dfs1('A');
		System.out.println();
		dfs2('A');
		System.out.println();
		dfs3('A');
	}

	private static void dfs1(char c) {
		System.out.print(c);
		if (tree.get(c)[0] != '.') {
			dfs1(tree.get(c)[0]);
		}
		if (tree.get(c)[1] != '.') {
			dfs1(tree.get(c)[1]);
		}
	}

	private static void dfs2(char c) {
		if (tree.get(c)[0] != '.') {
			dfs2(tree.get(c)[0]);
		}
		System.out.print(c);
		if (tree.get(c)[1] != '.') {
			dfs2(tree.get(c)[1]);
		}
	}

	private static void dfs3(char c) {
		if (tree.get(c)[0] != '.') {
			dfs3(tree.get(c)[0]);
		}
		if (tree.get(c)[1] != '.') {
			dfs3(tree.get(c)[1]);
		}
		System.out.print(c);
	}

}
