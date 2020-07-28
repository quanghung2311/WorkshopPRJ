
package Thread;

import java.util.Scanner;

/**
 *
 * @author Quang Hung
 */
public class ThreadCount extends Thread{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = null;
        do{
            ThreadCount thread = new ThreadCount();
            System.out.println("Count down from 100 to 0 (that's decrease 1 every second)");
            thread.start();
            System.out.println("");
            key = sc.nextLine();
        }while(!key.equals("stop"));
    }
     @Override
    public void run() {
        int count = 100;
        for (int i = count; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
