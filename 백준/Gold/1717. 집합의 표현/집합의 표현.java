import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		
		makeSet();
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if(check==1) {
				num1 = find(num1);
				num2 = find(num2);
				if(num1==num2) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			} else if(check==0) {
				unoin(num1, num2);
			}
		}
	}

	private static void unoin(int x, int y) {
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
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
	}

}
