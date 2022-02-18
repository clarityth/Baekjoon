import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15829 {
    // Hashing
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long hash = 0;
        for(int i=0; i<l; i++){
            hash += ((str.charAt(i)-'a'+1) * Math.pow(31,i));
        }
        System.out.println(hash%1234567891);
    }
}