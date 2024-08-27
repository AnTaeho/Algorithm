import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int k;
    static List<Integer> dp = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        fun();
    }

    public static void fun() {

        dp.add(0);
        for (int i = 0; i < k; i++) {
            dp.add(0);
        }

        dp.set(0,1);

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp.set(j, dp.get(j) + dp.get(j - arr[i]));
            }
        }

        System.out.println(dp.get(k));
    }
}