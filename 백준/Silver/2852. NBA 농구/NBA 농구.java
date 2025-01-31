
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int team1M = 0, team2M = 0;
		int team1Score = 0, team2Score = 0;
		int temp = 0;
		int[][] input = new int[N + 1][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = timeToInt(st.nextToken());
		}
		input[N][1] = 2880;
		for (int i = 0; i <= N; i++) {
			if (input[i][0] == 1) {
				if (team1Score > team2Score) {
					team1M += input[i][1] - input[i - 1][1];
				} else if (team1Score < team2Score) {
					team2M += input[i][1] - input[i - 1][1];
				}
				team1Score++;
			} else {
				if (team1Score > team2Score) {
					team1M += input[i][1] - input[i - 1][1];
				} else if (team1Score < team2Score) {
					team2M += input[i][1] - input[i - 1][1];
				}
				team2Score++;
			}
		}
		System.out.println(intToTime(team1M));
		System.out.println(intToTime(team2M));

	}

	public static int timeToInt(String time) {
		String[] hm = time.split(":");
		return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
	}

	public static String intToTime(int time) {
		String m = time / 60 < 10 ? "0" + time / 60 : "" + time / 60;
		String s = time % 60 < 10 ? "0" + time % 60 : "" + time % 60;
		return m + ":" + s;
	}
}