import java.util.Scanner;
public class B10773 {
    public static int[] stack;
    public static int pointer = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int res = 0;

        stack = new int[n];

        for (int i=0; i<n; i++){
            int num = sc.nextInt();
            if (num == 0){
                pop();
            } else {
                push(num);
            }
        }

        int i = 0;
        while (stack[i] != 0){
            res += stack[i];
            i++;
        }
        System.out.println(res);
    }
    public static void push(int n) {
        stack[pointer] = n;
        pointer++;
    }
    public static void pop() {
        stack[pointer - 1] = 0;
        pointer--;
    }
}
