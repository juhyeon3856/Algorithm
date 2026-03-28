import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static int[] nums, needCnt, dp; // 입력받은 숫자, i번째가 꼭 들어갈 때 최소 길이, i번째까지 볼 때 가장 최소 길이 

	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("./src/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		needCnt = new int[N];
		dp = new int[N];
		
		 st = new StringTokenizer(br.readLine());
		 for (int i = 0; i < N; i++) {
			nums[i] =  Integer.parseInt(st.nextToken());
		}
		
		makeNeedCnt();
		
		makeDP();
		
		int ans = N+1;
		for (int i = 0; i < N; i++) {
			ans = Math.min(ans, dp[i]);
		}
		System.out.println(ans == N+1 ? 0 : ans);
		
		
		


	}

	private static void makeDP() {
		dp[0] = needCnt[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.min(needCnt[i], dp[i-1]);
		}
	}

	private static void makeNeedCnt() {
		int i = 0;
		int sum = 0;
		for (int j = 0; j < N; j++) {
			sum += nums[j];
			if(sum >= S) {
				while(sum - nums[i] >= S) {
					sum -= nums[i];
					i++;
				}
				needCnt[j] = j - i + 1;
			} else {
				needCnt[j] = N+1; // 불가능함 
			}
		}
	}


}
