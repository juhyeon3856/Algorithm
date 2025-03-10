import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static class Edge {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int n, m;
    static int[] boss;
    static PriorityQueue<Edge> points = new PriorityQueue<>((o1, o2) -> (Integer.compare(o1.w, o2.w)));
    static long result;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boss = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            boss[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            points.add(new Edge(s, e, w));
            max += w;
        }

        int cnt = 0;
        while (!points.isEmpty()) {
            Edge tmp = points.poll();
            if (union(tmp.e, tmp.s)) {
                cnt++;
                result += tmp.w;
            }
            if(cnt == n-1){
                System.out.println(max-result);
                return;
            }        
        }
        System.out.println(-1);

    }

    private static boolean union(int e, int s) {
        int A = bossfind(e);
        int B = bossfind(s);
        if(A ==B){
            return false;
        }
        boss[A] = B;
        return true;
    }

    private static int bossfind(int e) {
        if(e == boss[e]){
            return e;
        }
        return boss[e] = bossfind(boss[e]);
    }
}
