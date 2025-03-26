import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N];
		
		makeSet();
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int firstBoss = find(Integer.parseInt(st.nextToken())-1);
		for (int i = 1; i < M; i++) {
			int nextBoss = find(Integer.parseInt(st.nextToken())-1);
			if(firstBoss!= nextBoss) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) {
			p[x] = y;
		} else {
			p[y] = x;
		}
	}

	private static int find(int x) {
		if(p[x] == x) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}

}
