import java.util.Scanner;

public class Main {

	static int N;
	static int[][] star;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		star = new int[N][N];
		
		StringBuilder sb = new StringBuilder();
		sol(sb);
		System.out.println(sb.toString());
	}
	
	public static void sol(StringBuilder sb) {
		makeStar(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(star[i][j] == 0) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
	}
	
	public static void makeStar(int n, int r, int c) {
		if(n>1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1&&j==1) {
						for (int j2 = 0; j2 < n/3; j2++) {
							for (int k = 0; k < n/3; k++) {
								star[r+n/3+j2][c+n/3+k] = 1;
							}
						}
					} else {
						makeStar(n/3, r+i*n/3, c+j*n/3);
					}
				}
			}
		}		
	}
}
