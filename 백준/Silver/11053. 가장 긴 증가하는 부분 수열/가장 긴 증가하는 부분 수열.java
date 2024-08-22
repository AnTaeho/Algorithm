import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
                
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
    
		        if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
			        dp[i] = dp[j] + 1;
		        }
	        }
        }
        
        int max = dp[0];

        for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
    }
    
}