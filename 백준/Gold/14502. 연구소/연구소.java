import java.util.*;

public class Main {
    
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int[][] copyMap;
    static Queue<virus> queue = new LinkedList<virus>();
    static int maxSafetyRoom = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        n = in.nextInt();
        m = in.nextInt();
        
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
        
        dfs(0);
        
        System.out.print(maxSafetyRoom);
    }
    
    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void bfs(){


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    queue.offer(new virus(i,j));
                }
            }
        }

        copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()){
            virus v = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if(0 <= nx && nx < n && 0<= ny && ny < m) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        queue.add(new virus(nx, ny));
                    }
                }
            }

        }

        funcSafeZone(copyMap);
    }
    
    private static void funcSafeZone(int[][] copyMap) {
        int safeZone =0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        maxSafetyRoom = Math.max(safeZone, maxSafetyRoom);

    }
    
    static class virus{
        int x;
        int y;
        public virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}