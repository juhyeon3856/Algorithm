import java.util.Scanner;

public class Main {
	private static int[] p;
	private static int N, M, R;
	private static int[] nums;
	private static int min = Integer.MAX_VALUE;
	private static int answer;
	
	public static void main(String[] args) {
		R=3;
		nums = new int[R];
		
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = sc.nextInt();
		}
		
		combi(0, 0, 0);
		System.out.println(answer);
		
	}
	
	public static void combi(int cnt, int start, int tot) {
		if(cnt==R) {
			if(M >= tot && min > M-tot){
				min =  Math.abs(M-tot);
				answer = tot;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = p[i];
			combi(cnt+1, i+1, tot+p[i]);
			nums[cnt] = 0;
		}
	}
}
