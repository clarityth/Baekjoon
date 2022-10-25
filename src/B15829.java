import java.io.*;
import java.util.*;

public class B15829 {
    // Hashing
    final static int m = 1234567891;
    final static int r = 31;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long hash = 0;
        for(int i=0; i<l; i++){
            hash += (str.charAt(i)-'a'+1)*pow(r,i);
        }
        System.out.println(hash%m);
    }
    public static long pow(int a, int b){ // Large Case : Overflow를 고려
        return b==0 ? 1 : a * pow(a,b-1) % m;
    }
}