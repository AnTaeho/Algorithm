import java.util.*;

public class Main {
    
    static int[][] map;
    static boolean[] visited;
    static int n;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        int k = in.nextInt();
        
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        int answer = 0;
        
        for (int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            
            map[a][b] = map[b][a] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        System.out.print(answer);
    }
    
    private static void dfs(int num) {
        visited[num] = true;
        for (int i = 1; i <= n; i++) {
            if (map[num][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
}