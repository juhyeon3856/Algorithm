import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int n = 19;

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Test5.txt"));
		// ---------여기에 코드를 작성하세요.---------------//
		Scanner sc = new Scanner(System.in);
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] != 0 && isWin(i, j)) {
					System.out.println(map[i][j]);
					int r = i+1, c = j+1;
					System.out.println(r + " " + c);
					return;
				}
			}
		}
		System.out.println(0);

	}
	
	public static boolean isWin(int r, int c) {
		int answer = map[r][c];
		boolean result1 = true;
		boolean result2 = true;
		boolean result3 = true;
		boolean result4 = true;
		if(check(r+1, c-1)&& map[r+1][c-1]==answer) result1 = false;
		if(check(r, c-1)&& map[r][c-1]==answer) result2 = false;
		if(check(r-1, c-1)&& map[r-1][c-1]==answer) result3 = false;
		if(check(r-1, c)&& map[r-1][c]==answer) result4 = false;
		
		for (int i = 1; i < 5; i++) {
			if(result1 && !(check(r-i, c+i) && map[r-i][c+i]==answer)) {
				result1 = false;
			}
			if(result2 && !(check(r, c+i) && map[r][c+i]==answer)) {
				result2 = false;
			}
			if(result3 && !(check(r+i, c+i) && map[r+i][c+i]==answer)) {
				result3 = false;
			}
			if(result4 && !(check(r+i, c) && map[r+i][c]==answer)) {
				result4 = false;
			}
		}
		if(result1 && check(r-5, c+5) && map[r-5][c+5]==answer) {
			result1 = false;
		}
		if(result2 && check(r, c+5) && map[r][c+5]==answer) {
			result2 = false;
		}
		if(result3 && check(r+5, c+5) && map[r+5][c+5]==answer) {
			result3 = false;
		}
		if(result4 && check(r+5, c) && map[r+5][c]==answer) {
			result4 = false;
		}
		return result1 || result2 || result3 || result4;
		
	}
		
	public static boolean check(int r, int c) {
		return r>=0 && r<n && c>=0 && c<n;
	}

}
