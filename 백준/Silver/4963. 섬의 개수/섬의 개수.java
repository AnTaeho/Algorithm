import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();

            if (m == 0 && n == 0) {
                break;
            }

            map = new int[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                String tempStr = sc.nextLine();
                String[] nums = tempStr.split(" ");

                for (int j = 0; j < nums.length; j++) {
                    map[i][j] = Integer.parseInt(nums[j]);
                }
            }

            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}