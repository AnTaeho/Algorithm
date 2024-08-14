import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int k = in.nextInt();
        
        List<Gem> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = in.nextInt();
            int v = in.nextInt();
            list.add(new Gem(m, v));
        }
        Collections.sort(list, (o1, o2) -> o1.m - o2.m);
        
        int[] weight = new int[k];
        for(int i = 0; i < k; i++) {
            weight[i] = in.nextInt();
        }
        
        Arrays.sort(weight);
        
        long total = 0;
        int idx = 0;
        PriorityQueue<Gem> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        for(int i = 0; i < k; i++) {
            while(idx < n && list.get(idx).m <= weight[i]) {
                Gem current = list.get(idx++);
                pq.add(new Gem(current.m, current.v));
            }
            if(!pq.isEmpty()) total += pq.poll().v;
        }
        System.out.println(total);
        
    }
    
    public static class Gem {
        int m;
        int v;
        
        public Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    
}