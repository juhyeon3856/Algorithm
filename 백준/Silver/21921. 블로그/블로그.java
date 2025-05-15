import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		int[] visited = new int[N];
		for (int i = 0; i < N; i++) {
			visited[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += visited[i];
		}
		int max = sum;
		int count = 1;
		
		for (int i = 0, j=X; j < N; i++, j++) {
			sum -= visited[i];
			sum += visited[j];
			if(max == sum) {
				count++;
			} else if( max < sum) {
				max = sum;
				count = 1;
			}
		}
		if(max > 0) {
		System.out.println(max);
		System.out.println(count);
		} else {
			System.out.println("SAD");
		}
		
	}

}