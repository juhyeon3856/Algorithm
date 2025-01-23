import java.util.Scanner;

public class Main {
	
	private static int[][] p;
	private static int N;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N][2];
		for (int i = 0; i < N; i++) {
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			combi(0, 0, 1, 0, i+1);
		}
		System.out.println(min);
	}

	private static void combi(int depth, int start, int mul, int tot, int R) {
		if(R==depth) {
			min = Math.abs(tot-mul)<min ?  Math.abs(tot-mul) : min;
		}
		for (int i = start; i < N; i++) {
			combi(depth+1, i+1, mul*p[i][0], tot+p[i][1], R);
		}
	}
}
