import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] data = new int[H + X + X][W + Y + Y];
		StringBuilder sb = new StringBuilder();

		for (int i = X; i < H + X + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = Y; j < W + Y + Y; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				data[i + X][j + Y] -= data[i][j];
				sb.append(data[i + X][j + Y]).append(" ");
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
