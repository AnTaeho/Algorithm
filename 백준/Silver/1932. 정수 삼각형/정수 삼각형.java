import java.util.*;

public class Main {
    
    static int[][] map;
    static Integer[][] dp;
    static int n;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        map = new int[n][n];
        dp = new Integer[n][n];
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				map[i][j] = in.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			dp[n - 1][i] = map[n - 1][i];
		}
        
        System.out.print(find(0, 0));
    }
    
    private static Integer find(int depth, int idx) {
        if(depth == n - 1) return dp[depth][idx];
 
		// 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
		if (dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + map[depth][idx];
		}
		return dp[depth][idx];
    }
    
}