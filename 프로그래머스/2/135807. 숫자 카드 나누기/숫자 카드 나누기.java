import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(find(arrayA, arrayB), find(arrayB, arrayA));
    }

    private int find(int[] A, int[] B) {
        int gcd = Arrays.stream(A).reduce(0, (a, b) -> gcd(a, b));

        List<Integer> divisors = getDivisors(gcd);

        for (int c : divisors) {
            boolean valid = true;
            for (int b : B) {
                if (b % c == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) return c;
        }

        return 0;
    }

    private List<Integer> getDivisors(int a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                set.add(i);
                set.add(a / i);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());
        return list;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}