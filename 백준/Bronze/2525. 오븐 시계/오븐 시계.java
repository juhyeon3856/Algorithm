import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        c += b;
        a += c/60;
        a %= 24;
        b = c%60;
        System.out.println(a + " " + b);
    }
}