import java.util.*;

public class Main {

    static int n,m;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = in.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'S') {
                    q.add(new int[]{i, j, 0});
                } else if(map[i][j] == '*'){
                    water.add(new int[]{i, j});
                }
            }
        }

        bfs();
        System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int len = water.size();
            for (int i = 0; i < len; i++) {
                int[] temp = water.poll();
                int x = temp[0];
                int y = temp[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny]=='.') {
                        map[nx][ny] = '*';
                        water.add(new int[]{nx,ny});
                    }
                }
            }

            len = q.size();
            for(int i = 0; i < len; i++){
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                int time = temp[2];
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny]=='D'){
                            answer = Math.min(answer, time + 1);
                            return;
                        } else if(map[nx][ny] == '.'){
                            map[nx][ny] = 'S';
                            q.add(new int[]{nx, ny, time + 1});
                        }
                    }
                }
            }
        }
    }

}