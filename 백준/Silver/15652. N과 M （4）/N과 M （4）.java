import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N, R;
	public static int[] nums;
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nums = new int[R];
		perm(0, 0);
		System.out.println(sb);
	}

	private static void perm(int depth, int start) throws Exception  {
		if(R==depth) {
			for (int i = 0; i < R; i++) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			nums[depth] = i+1;
			perm(depth+1, i);
			nums[depth] = 0;
		}
	}
}
