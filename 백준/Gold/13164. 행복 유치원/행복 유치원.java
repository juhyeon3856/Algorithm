import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] diff;
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		diff = new int[N];
		st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			diff[i] = cur - prev;
			prev = cur;
		}
//		System.out.println(Arrays.toString(diff));
		Arrays.sort(diff);
		int answer = 0;
		int w = N-K+1;
//		System.out.println(Arrays.toString(diff));
		for (int i = 1; i < w; i++) {
			answer+=diff[i];
		}
		System.out.println(answer);
		
	}
}
