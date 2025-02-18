import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    static int[][] sortList;
    static int N, M;
    static List<Integer>[] tree;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
 
            sortList = new int[N][N]; // 나보다 작은친구 -1, 나보다 큰 친구 1, 모르는 친구 0 -> 나를 제외하고 0이 없으면 등수를 정확하게 알 수 있음
            tree = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<>();
            }
 
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken()) - 1;
                int n2 = Integer.parseInt(st.nextToken()) - 1;
                tree[n1].add(n2);
                sortList[n1][n2] = 1;
                sortList[n2][n1] = -1;
            }
 
            /// 입력 완료 입력 테스트 시작
 
//          System.out.println(N + " : " + M);
//          for (int i = 0; i < N; i++) {
//              System.out.println(Arrays.toString(sortList[i]));
//          }
//          for (int i = 0; i < N; i++) {
//              System.out.println(tree[i]);
//          }
 
            // 입력 테스트 완료 로직 시작
            for (int i = 0; i < N; i++) {
                bfs(i);
            }
 
            int answer = 0;
            for (int i = 0; i < N; i++) {
                int zeroCount = 0;
                for (int j = 0; j < N; j++) {
                    if (sortList[i][j] == 0) {
                        zeroCount++;
                    }
                }
                if (zeroCount == 1) {
                    answer++;
                }
 
            }
            System.out.println(answer);

    }
 
    private static void bfs(int personNum) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int num : tree[personNum]) {
            queue.offer(num);
        }
 
        while (!queue.isEmpty()) {
            int q = queue.poll();
 
            for (int num : tree[q]) {
                if (sortList[personNum][num] == 0) {
                    queue.offer(num);
                    sortList[personNum][num] = 1;
                    sortList[num][personNum] = -1;
                }
            }
        }
 
    }
 
}