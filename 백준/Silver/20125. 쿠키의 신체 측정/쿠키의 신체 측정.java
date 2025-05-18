import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int check = 0;
		char[][] data = new char[N][N];
		int[] heart = new int[2];
		int[] leg = new int[2];
		int leftArm = 0;
		int rightArm = 0;
		int waist = 0;
		int leftLeg = 0;
		int rightLeg = 0;

		// 데이터 받고, 심장위치, 다리 시작하는 위치 잡기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = str.charAt(j);
				if (check == 0 && data[i][j] == '*') {
					check = 1;
					heart[0] = i + 1;
					heart[1] = j;
				}
				if (i > heart[0] + 1 && j + 1 == heart[1] && data[i][j] == '*' && check == 1) {
					check = 2;
					leg[0] = i;
					leg[1] = j + 1;
				}
			}
		}

		int r, c;

		// 왼쪽 팔 길이
		r = heart[0];
		c = heart[1] - 1;
		while (c >= 0 && data[r][c] == '*') {
			c--;
			leftArm++;
		}

		// 오른쪽 팔 길이
		r = heart[0];
		c = heart[1] + 1;
		while (c < N && data[r][c] == '*') {
			c++;
			rightArm++;
		}

		// 허리 길이
		waist = leg[0] - heart[0] - 1;

		// 왼쪽 다리 길이
		r = leg[0];
		c = leg[1] - 1;
		while (r < N && data[r][c] == '*') {
			r++;
			leftLeg++;
		}

		// 오른쪽 다리 길이
		r = leg[0];
		c = leg[1] + 1;
		while (r < N && data[r][c] == '*') {
			r++;
			rightLeg++;
		}

		System.out.println((heart[0] + 1) + " " + (heart[1] + 1) + "\n" + leftArm + " " + rightArm + " " + waist + " "
				+ leftLeg + " " + rightLeg);
	}

}
