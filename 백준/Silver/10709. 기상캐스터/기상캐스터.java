
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j)=='c') {
					System.out.print("0 ");
					board[i][j] = 0;
				} else {
					int back = 1;
					while(j>=back) {
						if(board[i][j-back]>=0) {
							System.out.print(board[i][j-back] + back + " ");
							board[i][j] = board[i][j-back] + back;
							break;
						}
						back++;
					}
					if(j<back) {
						System.out.print("-1 ");
						board[i][j] = -1;
					}
				}
			}
			System.out.println();
		}
        
	}
}