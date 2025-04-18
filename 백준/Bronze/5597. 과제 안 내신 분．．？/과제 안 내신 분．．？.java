import java.io.*;

class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] list = new boolean[31];
        for(int i = 1; i<=28; i++){
            list[Integer.parseInt(br.readLine())] = true;
        }
        for(int i = 1; i<=30; i++){
            if(!list[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}