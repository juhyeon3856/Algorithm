import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] lst;
    static int[] minTree;
    static int[] maxTree;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lst = new int[N];
        for (int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(br.readLine());
        }


        minTree = new int[N * 4];
        maxTree = new int[N * 4];
        minBuild(0, N, 1);
        maxBuild(0, N, 1);

//        System.out.println(Arrays.toString(tree));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken());
            sb.append(minSelect(0, N, s, e, 1));
            sb.append(" ");
            sb.append(maxSelect(0, N, s, e, 1));
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void minBuild(int l, int r, int i) {
        if (l + 1 == r) {
            if (l < N) {
                minTree[i] = lst[l];
            }
            return;
        }
        int mid = (l + r) >> 1;
        minBuild(l, mid, i << 1);
        minBuild(mid, r, i << 1 | 1);

        minTree[i] = min(minTree[i << 1], minTree[(i << 1) | 1]);
    }


    public static int maxSelect(int l, int r, int gl, int gr, int i) {
        if (gr <= l || gl >= r) { //범위 밖
            return 0;
        }
        if (l >= gl && r <= gr) {
            return maxTree[i];
        }
        int mid = (l + r) >> 1;
        return max(maxSelect(l, mid, gl, gr, i << 1), maxSelect(mid, r, gl, gr, i << 1 | 1));
    }

    public static void maxBuild(int l, int r, int i) {
        if (l + 1 == r) {
            if (l < N) {
                maxTree[i] = lst[l];
            }
            return;
        }
        int mid = (l + r) >> 1;
        maxBuild(l, mid, i << 1);
        maxBuild(mid, r, i << 1 | 1);

        maxTree[i] = max(maxTree[i << 1], maxTree[(i << 1) | 1]);
    }


    public static int minSelect(int l, int r, int gl, int gr, int i) {
        if (gr <= l || gl >= r) { //범위 밖
            return 2_000_000_000;
        }
        if (l >= gl && r <= gr) {
            return minTree[i];
        }
        int mid = (l + r) >> 1;
        return min(minSelect(l, mid, gl, gr, i << 1), minSelect(mid, r, gl, gr, i << 1 | 1));
    }

    public static int min(int n1, int n2){
        return n1 > n2 ? n2 : n1;
    }

    public static int max(int n1, int n2){
        return n1 < n2 ? n2 : n1;
    }

}