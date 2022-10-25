import java.util.Scanner;

public class B2684 {
    // 동전게임
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();

        for (int i=0; i<P; i++){
            String str = sc.next();
            int[] arr = new int[8];
            for (int j=0; j<38; j++){
                String s = str.substring(j, j+3);
                if (s.equals("TTT"))
                    arr[0]++;
                if (s.equals("TTH"))
                    arr[1]++;
                if (s.equals("THT"))
                    arr[2]++;
                if (s.equals("THH"))
                    arr[3]++;
                if (s.equals("HTT"))
                    arr[4]++;
                if (s.equals("HTH"))
                    arr[5]++;
                if (s.equals("HHT"))
                    arr[6]++;
                if (s.equals("HHH"))
                    arr[7]++;
            }
            for (int k=0; k<8; k++){
                System.out.printf(arr[k] + " ");
            }
            System.out.printf("\n");
        }
    }
}
