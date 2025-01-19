
import java.util.*;

public class Main {


	// 전역변수 작성하기 
	static int[][] board;
	static int negativeCount;
	static int zeroCount;
	static int positiveCount;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		//변수 초기화
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		//재귀함수 호출
		function(0, 0, N);
	
		
		//답 출력
		System.out.println(negativeCount);
		System.out.println(zeroCount);
		System.out.println(positiveCount);
	}
	
	public static boolean baseCondition(int r, int c, int n) {
		boolean result = true;
		int num = board[r][c];
		aa : for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(num != board[r+i][c+j]) {
					result = false;
					break aa;
				}
			}
		}
		return result;
	}
	
	public static void function(int r, int c, int n) {
		
		if(baseCondition(r, c, n)) {
			// 초기 로직 구현하기 
			if(board[r][c]==-1) {
				negativeCount++;
			} else if(board[r][c]==0) {
				zeroCount++;
			} else if(board[r][c]==1) {
				positiveCount++;
			}
		} else {
			// 점화식 구현하기 
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					function(r+n/3*i, c+n/3*j, n/3);
				}
			}
		}
	}
}