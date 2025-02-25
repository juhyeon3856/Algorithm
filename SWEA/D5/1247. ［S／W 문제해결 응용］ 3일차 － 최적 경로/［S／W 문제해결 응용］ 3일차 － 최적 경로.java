import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static public class Cell {
		int r;
		int c;

		public Cell(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static Cell office;
	static Cell home;
	static Cell[] customers;
	static int N, answer;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			customers = new Cell[N];
			nums = new int[N];
			answer = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			office = new Cell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Cell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				nums[i] = i;
				customers[i] = new Cell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			do {
				int dist = baseCondition();
				if (dist < answer) {
					answer = dist;
				}
			} while (np(N - 1));
			System.out.println("#" + t + " " + answer);
		}

	}

	private static int baseCondition() {
		int dist = norm(office, customers[nums[0]]);
		for (int i = 1; i < N; i++) {
			dist += norm(customers[nums[i - 1]], customers[nums[i]]);
		}
		dist += norm(customers[nums[N - 1]], home);
//		System.out.println(dist);
		return dist;
	}

	private static int norm(Cell c1, Cell c2) {
		return Math.abs(c1.r - c2.r) + Math.abs(c1.c - c2.c);
	}

	private static boolean np(int size) {
		int i = size;
		while (i > 0 && nums[i - 1] > nums[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (nums[i - 1] > nums[j])
			j--;
		int temp = nums[i - 1];
		nums[i - 1] = nums[j];
		nums[j] = temp;
		int k = size;
		while (i < k) {
			temp = nums[k];
			nums[k] = nums[i];
			nums[i] = temp;
			i++;
			k--;
		}
		return true;
	}

}
