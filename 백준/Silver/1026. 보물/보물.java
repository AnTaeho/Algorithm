import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr1[i] * arr2[n-1-i];
        }
        System.out.print(sum);
    }
    
}