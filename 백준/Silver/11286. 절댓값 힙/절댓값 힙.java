import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				}else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else {
					return -1;
				}
			}
		});
        
        StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			int x = in.nextInt();
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0").append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
    }
    
}