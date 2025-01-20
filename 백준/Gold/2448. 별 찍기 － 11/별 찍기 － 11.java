import java.util.Scanner;

public class Main {

	static int N;
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N*2];
		StringBuilder sb = new StringBuilder();
		sol(N, 0, N-1);
		print(sb);
		System.out.println(sb.toString());
	}
	
	public static void print(StringBuilder sb) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N*2; j++) {
				if(board[i][j]==0) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
	}
	
	public static void sol(int n, int r, int c) {
		if(n==3) {
			board[r][c] = 1;
			board[r+1][c-1] = 1;
			board[r+1][c+1] = 1;
			for (int i = 0; i < 5; i++) {
				board[r+2][c+i-2] = 1;
			}
		} else {
			int m = n/2;
			sol(m, r, c);
			sol(m, r+m, c-m);
			sol(m, r+m, c+m);
		}
	}
}
