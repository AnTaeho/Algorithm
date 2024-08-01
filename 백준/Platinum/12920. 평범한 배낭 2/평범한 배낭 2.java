import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        List<Thing> things = new ArrayList<>();
        things.add(new Thing(0, 0));
        
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            int c = in.nextInt();
            int k = in.nextInt();
            
            int temp = 1;
            while (temp <= k) {
                things.add(new Thing(temp * v, temp * c));
                k -= temp;
                temp *= 2;
            }
            
            if (k != 0) {
                things.add(new Thing(k * v, k * c));
            }
        }
        
        int[][] dp = new int[things.size() + 1][m + 1];
        for (int i = 1; i < things.size(); i++) {
            for (int j = 1; j <= m; j++) {
                if (j < things.get(i).weight) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - things.get(i).weight] + things.get(i).value);
                }
            }
        }
        System.out.println(dp[things.size() - 1][m]);
    }
    
    static class Thing {
        int weight;
        int value;
        
        public Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    
}