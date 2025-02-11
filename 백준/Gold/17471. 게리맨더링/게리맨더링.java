import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited, connected;
	static int N, answer;
	static List<Integer>[] tree;
	static int[] people;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			answer += people[i];
		}
		int peopleNum=answer;
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j < c; j++) {
				tree[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		visited = new boolean[N];
		subset(0);
		if(answer==peopleNum) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void subset(int depth) {
		if (depth == N) {
			baseCondition();
			return;
		}
		visited[depth] = true;
		subset(depth + 1);
		visited[depth] = false;
		subset(depth + 1);
	}
	

	private static void baseCondition() {
		boolean con = true;
		for (int i = 1; i < N; i++) {
			con = con && visited[i]==visited[i-1];
		}
		if(con || !check()) return;
		int subValue = 0;
		for (int i = 0; i < N; i++) {
			if(visited[i]) {
				subValue+=people[i];
			} else {
				subValue-=people[i];
			}
		}
		subValue = Math.abs(subValue);
		answer = answer > subValue ? subValue : answer;
	}

	private static boolean check() {
		connected = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		int firstTrue = first(true);
		queue.offer(firstTrue);
		connected[firstTrue] = true;
		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int num : tree[q]) {
				if (visited[num] && !connected[num]) {
					queue.offer(num);
					connected[num] = true;
				}
			}
		}

		int firstFalse = first(false);
		queue.offer(firstFalse);
		connected[firstFalse] = true;
		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int num : tree[q]) {
				if (!visited[num] && !connected[num]) {
					queue.offer(num);
					connected[num] = true;
				}
			}
		}
		boolean result = true;
		for (int i = 0; i < N; i++) {
			result = result && connected[i];
		}
		return result;
	}

	private static Integer first(boolean type) {
		for (int i = 0; i < N; i++) {
			if (visited[i] == type)
				return i;
		}
		return null;
	}

}
