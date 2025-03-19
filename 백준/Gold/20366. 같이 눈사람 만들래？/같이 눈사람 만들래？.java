import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] paper;
    static int[] select;
    static boolean[] visited;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        Arrays.sort(paper);
        select = new int[2];

        combi(0, 0);
        System.out.println(result);
    }

    private static void combi(int cnt, int start) {
        if (cnt == 2) {
            check();
            // System.out.println(Arrays.toString(select));
            return;
        }
        for (int i = start; i < N; i++) {
            if(visited[i]){
                continue;
            }
            select[cnt] = i;
            visited[i] = true;
            combi(cnt + 1, i + 1);
            visited[i] = false;
        }
    }

    private static void check() {
        int s1 = paper[select[0]];
        int e1 = paper[select[1]];
        int tmp = s1 + e1;
        int idxStart = 0;
        int idxEnd = N;

        for (int i = 0; i < N;) {
            for (int j = N - 1; j >= 0;) {
                if(visited[i]){
                    i++;
                    continue;
                }
                if(visited[j]){
                    j--;
                    continue;
                }
                if(j<=0 || i>=N-1 || i>=j){
                    return;
                }
                int s2 = paper[i];
                int e2 = paper[j];
                int tmp2 = s2 +e2;
                result = Math.min(result, Math.abs(tmp2-tmp));
                // System.err.println(s1 + " " + e1 + " ");
                // System.out.println(tmp + " : " + tmp2 + " result " + result);
                if(result==0){
                    return;
                }
                if(tmp>tmp2){
                    i++;
                }else{
                    j--;
                }
            }
        }
        return;
    }
}