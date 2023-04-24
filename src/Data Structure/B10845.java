// 큐
import java.util.Scanner;

public class B10845 {
  public static int[] queue = new int[10000];
  public static int front = 0, rear = 0, size = 0;
  public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    for (int i = 0; i < n; ++i){
      String str = sc.next();
      switch (str){
        case "push":
          push(sc.nextInt());
          break;

        case "pop":
          sb.append(pop()+"\n");
          break;

        case "size":
          sb.append(size() + "\n");
          break;

        case "empty":
          sb.append(empty()+"\n");
          break;

        case "front":
          sb.append(front()+"\n");
          break;

        case "back" :
          sb.append(back()+"\n");
          break;
      }
    }
    System.out.println(sb);
  }
  public static void push(int x){
    queue[rear++] = x;
    size++;
  }

  public static int pop(){
    if (size == 0)
      return -1;
    else {
      int item = queue[front];
      queue[front++] = 0;
      size--;
      return item;
    }
  }

  public static int size(){
    return size;
  }

  public static int empty() {
    if (size == 0)
      return 1;
    else
      return 0;
  }

  public static int front() {
    if (size == 0)
      return -1;
    else
      return queue[front];
  }

  public static int back() {
    if (size == 0)
      return -1;
    else
      return queue[rear-1];
  }
}
