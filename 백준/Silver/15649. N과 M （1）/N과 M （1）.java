import java.util.Scanner;

public class Main {
	private static int[] p;
	private static int N, R;
	private static int[] nums;
	private static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		nums = new int[R];
		visited = new boolean[N];
		
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i+1;
		}
		
		func(0, 0);
		sc.close();
	}
	
	public static void func(int cnt, int start) {
		if(cnt==R) {
			for (int i = 0; i < R; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			nums[cnt] = p[i];
			visited[i]=true;
			func(cnt+1, i+1);
			visited[i]=false;
			nums[cnt] = 0;
				
		}
	}
}
