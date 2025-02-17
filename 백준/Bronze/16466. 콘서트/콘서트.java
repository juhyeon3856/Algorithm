import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		for (int i = 1; i <= N; i++) {
			if(nums[i-1]!=i) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(N+1);
		
	}
}
