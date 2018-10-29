package sw;
import java.util.*;
 
public class p2805 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] tree = new long[n];
        long l = 1;
        long r = 0;
        for(int i=0; i<n; i++) {
            tree[i] = sc.nextLong();
            r = Math.max(r, tree[i]);
        }
         
        long ans = 0;
        long result = 0;
        long h = 0;
        while(l<=r) {
            result = 0;
            h = (l+r)/2;
            for(int i=0; i<n; i++) {
                if (tree[i] - h > 0) {
                    result += (tree[i]-h);
                }
            }
            if (result >= m) {
                ans = Math.max(ans, h);
                l = h + 1;
            }
            else {
                r = h - 1;
            }
        }
         
        System.out.println(ans);
    }
}
