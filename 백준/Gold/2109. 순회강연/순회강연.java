import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static int[][] data;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        // 입력 완료! 로직 시작!

        // [1] 최대 시간 찾기
        int maxTime = 0;
        for (int[] value : data) {
            maxTime = maxTime < value[1] ? value[1] : maxTime;
        }

        int[] ansValue = new int[maxTime + 1];
        // [2] 로직
        for (int[] value : data) {
            int cv = value[0];
            int ct = value[1];
            for (int i = ct; i > 0; i--) {
                if (ansValue[i] < cv) {
                    int temp = ansValue[i];
                    ansValue[i] = cv;
                    cv = temp;
                }
            }
        }

        // [3] 정답 출력
        for (int num : ansValue) {
            ans += num;
        }
//        System.out.println(Arrays.toString(ansValue));
        System.out.println(ans);
    }
}