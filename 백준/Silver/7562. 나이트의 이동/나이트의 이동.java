import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] split = line1.split(" ");
            int currentX = Integer.parseInt(split[0]);
            int currentY = Integer.parseInt(split[1]);

            String line2 = br.readLine();
            String[] split1 = line2.split(" ");
            int destinationX = Integer.parseInt(split1[0]);
            int destinationY = Integer.parseInt(split1[1]);

            visited = new boolean[n][n];
            map = new int[n][n];

            bfs(currentX, currentY);

            bw.write(map[destinationX][destinationY] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<spot> queue = new LinkedList<>();
        queue.add(new spot(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            spot start = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = start.x + dx[i];
                int ny = start.y + dy[i];

                if (nx >= 0 && nx < n) {
                    if (ny >= 0 && ny < n) {
                        if (!visited[nx][ny]) {
                            queue.add(new spot(nx, ny));
                            map[nx][ny] = map[start.x][start.y] + 1;
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

        }
    }

    static class spot {
        int x;
        int y;

        spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}