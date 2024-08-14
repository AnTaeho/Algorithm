import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = newArr[i] = in.nextInt();
        }
        
        Arrays.sort(newArr);
        
        Map<Integer, Integer> ranking = new HashMap<>();
        int rank = 0;
		for(int v : newArr) {
			if(!ranking.containsKey(v)) {
				ranking.put(v, rank);
				rank++;	
			}
		}
        
        StringBuilder sb = new StringBuilder();
		for(int key : arr) {
			int temp = ranking.get(key);
			sb.append(temp).append(' ');
		}
		
		System.out.println(sb);
    }
    
}