import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int k = in.nextInt();
        
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            String name = in.next();
            map1.put(i, name);
            map2.put(name, i);
        }
        
        for (int i = 0; i < k; i++) {
            String input = in.next();
            try {
                int key = Integer.parseInt(input);
                System.out.println(map1.get(key));
            } catch (NumberFormatException e) {
                System.out.println(map2.get(input));
            }
        }
    }
    
}