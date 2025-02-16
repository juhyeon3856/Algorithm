import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, sum, answer;
	static int[] p;
	static int idx1, idx2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		sum = Integer.parseInt(br.readLine());
		
		Arrays.sort(p);
		idx1 = 0;
		idx2 = N-1;
		answer = 0;
		
		while(idx1 < idx2) {
			if(p[idx1] + p[idx2] == sum) {
				answer++;
				idx1++;
				idx2--;
			} else if(p[idx1] + p[idx2] < sum){
				idx1++;
			}else if(p[idx1] + p[idx2] > sum){
				idx2--;
			}
		}
		System.out.println(answer);
		
	}
}
