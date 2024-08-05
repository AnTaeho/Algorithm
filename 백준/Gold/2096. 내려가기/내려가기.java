import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        int[][] map = new int[n+1][3];
        
        for (int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = in.nextInt();
            }
        }
        
        int[][] minDp = new int[n + 1][3];
        int[][] maxDp = new int[n + 1][3];
        for(int i = 1; i <= n; i++) {
            maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + map[i][0];
            maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + map[i][1];
            maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + map[i][2];
            
            minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + map[i][0];
            minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + map[i][1];
            minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + map[i][2];
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, minDp[n][i]);
            max = Math.max(max, maxDp[n][i]);
        }
        System.out.println(max + " " + min);
    }
    
}