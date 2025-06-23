import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, appleCount, moveCount, currentTime;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int d = 0;
	static boolean[][] appleData;
	static boolean[][] snakeData;

	static class SnakeNode {
		int r;
		int c;
		SnakeNode prev;
		SnakeNode next;

		@Override
		public String toString() {
			return "SnakeNode [r=" + r + ", c=" + c + ", prev=" + prev + ", next=" + next + "]";
		}

		public SnakeNode(int r, int c, Main.SnakeNode prev, Main.SnakeNode next) {
			super();
			this.r = r;
			this.c = c;
			this.prev = prev;
			this.next = next;
		}

	}

	static SnakeNode head;
	static SnakeNode tail;

	public static void main(String[] args) throws Exception {
		// 입력 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		currentTime = 0;

		// appleData 입력 받기
		appleCount = Integer.parseInt(br.readLine());

		appleData = new boolean[N][N];
		for (int i = 0; i < appleCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			appleData[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true; // 해당 위치 사과 있음
		}

		// snakeData 초기화
		snakeData = new boolean[N][N];
		snakeData[0][0] = true;

		head = new SnakeNode(0, 0, null, null);
		tail = head;

//		System.out.println();
//		printmap(appleData);

		// 이동하기
		moveCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < moveCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String move = st.nextToken();

			// 직진 이동
			while (currentTime < time) {
				currentTime++;
				if (!straight()) {
					System.out.println(currentTime);
					return;
				}
//				System.out.println(currentTime);
//				printmap(snakeData);

			}

			if (move.equals("L")) {
				d = (d + 3) % 4;
			} else if (move.equals("D")) {
				d = (d + 1) % 4;
			}
		}

		while (straight()) {
//			printmap(snakeData);
			currentTime++;
		}
		System.out.println(currentTime + 1);

	}

//	private static void printmap(boolean[][] map) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (map[i][j]) {
//					System.out.print("T ");
//				} else {
//					System.out.print("F ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//	}

	private static boolean straight() {
		int nr = head.r + dr[d];
		int nc = head.c + dc[d];

		// 벽에 부딪히거나 자신의 몸에 부딪히면
		if (!check(nr, nc) || snakeData[nr][nc]) {

			return false;
		}

		// 이동이 성공적으로 일어나면

		// 머리를 옮긴다.
		SnakeNode node = new SnakeNode(nr, nc, null, head);
		head.prev = node;
		head = node;
		snakeData[nr][nc] = true;

		// 만약 사과가 있었으면
		if (appleData[nr][nc]) {
			// 사과를 지우고
			appleData[nr][nc] = false;
		} else { // 사과가 없었으면
			// 꼬리를 한칸 당긴다.
			snakeData[tail.r][tail.c] = false;
			tail = tail.prev;
		}
		return true;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
