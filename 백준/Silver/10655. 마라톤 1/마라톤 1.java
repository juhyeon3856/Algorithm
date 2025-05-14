import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int allSum = 0;
		int twoSum = 0;
		
		int secondPreX = Integer.parseInt(st.nextToken());
		int secondPreY = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int	firstPreX = Integer.parseInt(st.nextToken());
		int firstPreY = Integer.parseInt(st.nextToken());
		
		allSum += dist(secondPreX, secondPreY, firstPreX, firstPreY);
		twoSum = allSum;
		
		int[] jump = new int[N];
		
		for (int i = 2; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int nowX = Integer.parseInt(st.nextToken());
			 int nowY = Integer.parseInt(st.nextToken());
			 allSum += dist(firstPreX, firstPreY, nowX, nowY);
			 jump[i] = dist(firstPreX, firstPreY, nowX, nowY) 
					 + dist(secondPreX, secondPreY, firstPreX, firstPreY) 
					 - dist(secondPreX, secondPreY, nowX, nowY);
			 secondPreX = firstPreX;
			 secondPreY = firstPreY;
			 firstPreX = nowX;
			 firstPreY = nowY;
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, jump[i]);
		}
		System.out.println(allSum - max);
		
		
	}

	private static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1-y2);
	}
}
