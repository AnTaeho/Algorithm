import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int n;
    static String input;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new char[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;
        cnt = 0;
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;
        
        System.out.println(normal_cnt + " " + abnormal_cnt);

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char temp = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > n || ny > n) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] == temp) {
                dfs(nx, ny);
            }
        }
    }
    
}