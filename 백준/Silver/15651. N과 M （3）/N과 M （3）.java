import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N, R;
	public static int[] nums;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nums = new int[R];
		perm(0);
        bw.flush(); // 모든 출력 후 한 번에 처리
        bw.close(); // BufferedWriter 닫기
	}

	private static void perm(int depth) throws Exception  {
		if(R==depth) {
			for (int i = 0; i < R; i++) {
				bw.write(nums[i] + " ");
			}
			bw.newLine(); // 줄바꿈
			return;
		}
		for (int i = 0; i < N; i++) {
			nums[depth] = i+1;
			perm(depth+1);
			nums[depth] = 0;
		}
	}
}
