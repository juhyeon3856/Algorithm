import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        int sum = arr[0] + arr[1] + arr[2];
        if (sum % 3 != 0) {
            System.out.println(0);
        } else {
            System.out.println(solve(arr));
        }
    }

    static void transform(int[] arr, int i, int j) {
        if (arr[i] < arr[j]) {
            arr[j] -= arr[i];
            arr[i] *= 2;
        } else {
            arr[i] -= arr[j];
            arr[j] *= 2;
        }
    }

    static int solve(int[] arr) {
        while (true) {
            if (arr[0] == arr[1] && arr[1] == arr[2]) return 1;

            int oddCount = 0;
            int evenIdx = -1;
            for (int i = 0; i < 3; i++) {
                if (arr[i] % 2 == 0) {
                    evenIdx = i;
                } else {
                    oddCount++;
                }
            }

            if (oddCount == 2) {
                int aIdx = (evenIdx + 1) % 3;
                int bIdx = (evenIdx + 2) % 3;

                if (arr[aIdx] == arr[bIdx]) {
                    transform(arr, evenIdx, aIdx);
                    if (arr[evenIdx] == arr[bIdx]) return 0;  // ✅ 수정된 비교: 짝수와 다른 홀수(bIdx)가 같아졌는지 확인
                } else {
                    transform(arr, aIdx, bIdx);
                }
                continue;
            }

            if (oddCount == 1 || oddCount == 3) return 0;

            while (arr[0] % 2 == 0 && arr[1] % 2 == 0 && arr[2] % 2 == 0) {
                for (int i = 0; i < 3; i++) arr[i] /= 2;
            }
        }
    }
}