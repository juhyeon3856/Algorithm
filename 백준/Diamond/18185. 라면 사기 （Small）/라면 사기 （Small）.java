
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int pay = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 첫 번째 입력: N
        int[] nums = new int[N+3]; // 크기를 N으로 설정
        
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄에서 N개의 숫자 입력
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
		int idx = 0;
		while (idx < N) {
			if (nums[idx] == 0) {
				idx++;
			} else {
				for (int i = 1; i <= 3; i++) {
					if (nums[idx + i] < nums[idx + i - 1]) {
						nums[idx + i - 1]--;
						if (i == 1) {
							pay += 3;
						} else if (i == 2) {
							pay += 5;
						} else {
							pay += 7;
						}
						break;
					}
					nums[idx + i - 1]--;
					 if(i==3) pay += 7;
				}
			}
		}
		
		System.out.println(pay);
	}
}