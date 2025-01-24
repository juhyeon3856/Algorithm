
import java.util.*;

public class Main {

	// 전역변수 작성하기
	static int[][] star;
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		if (N == 1) {
			System.out.println("*");
			return;
		}

		// 변수 초기화
		int row = (int) Math.pow(2, N) - 1;
		star = new int[row][2 * row - 1];
		StringBuilder sb = new StringBuilder();

		// 재귀함수 호출
		function();
		listToString(sb);

		// 답 출력
		System.out.print(sb.toString());
	}

	public static void listToString(StringBuilder sb) {
		int row = (int) Math.pow(2, N) - 1;
		for (int i = 0; i < star.length; i++) {
			if(N%2==0) {
				for (int j = 0; j < 2*row-1-i; j++) {
					if (star[i][j] == 1) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
				if (i < star.length - 1) {
					sb.append("\n");
				}
			} else {
				for (int j = 0; j < row+i; j++) {
					if (star[i][j] == 1) {
						sb.append("*");
					} else {
						sb.append(" ");
					}
				}
				if (i < star.length - 1) {
					sb.append("\n");
				}
			}
			
		}
	}

	public static void function() {
		int r = 0, c = 0;

		for (int i = 0; i < N; i++) {
			int pow = (int) Math.pow(2, N - i);
			if ((N - i) % 2 == 0) {
				makeStarInv(N - i, r, c);
				r++;
				c += pow / 2;
			} else {
				makeStar(N - i, r, c);
				r += (pow / 2) - 1;
				c += pow / 2;
			}
		}
	}

	public static void makeStar(int n, int r, int c) {
		int pow = (int) Math.pow(2, n) - 1;
		for (int i = 0; i < pow - 1; i++) {
			star[r + i][c + pow - 1 - i] = 1;
			star[r + i][c + pow - 1 + i] = 1;
		}
		for (int i = 0; i < 2 * pow - 1; i++) {
			star[r + pow - 1][c + i] = 1;
		}
	}

	public static void makeStarInv(int n, int r, int c) {
		int pow = (int) Math.pow(2, n) - 1;
		for (int i = 0; i < 2 * pow - 1; i++) {
			star[r][c + i] = 1;
		}
		for (int i = 0; i < pow - 1; i++) {
			star[r + pow - i - 1][c + pow - 1 - i] = 1;
			star[r + pow - i - 1][c + pow - 1 + i] = 1;
		}

	}
}