import java.util.*;

public class Main {

	// 전역변수 작성하기  
	static int[][] star;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		
		//변수 초기화
		// 1->1, 2-> 5, 3->9 ===> n->4n-3
		star = new int[4*N-3][4*N-3];
		StringBuilder sb = new StringBuilder();

		
		//재귀함수 호출
		function(1);
        	listToString(sb);
		
		//답 출력
		System.out.println(sb.toString());
	}
	
	public static void function(int n) {
		int r = n*2-2;
		int num = 4*N-3-r*2;
		if(n==N) {
			// 초기 로직 구현하기 
			star[2*n-2][2*n-2] = 1;
		} else {
			// 점화식 구현하기
			for (int i = 0; i < num; i++) {
				star[r+i][r] = 1;
				star[r][r+i] = 1;
				star[r+i][r+num-1] = 1;
				star[r+num-1][r+i] = 1;
			}
            	function(n+1);
		}
	}
	
	public static void listToString(StringBuilder sb) {
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				if(star[i][j]==1) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
		sb.append("\n");
		}
	}
}
