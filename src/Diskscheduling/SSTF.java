package Diskscheduling;

import java.util.Scanner;

public class SSTF {

    private int visit[];
    private int nearIndex = 0;

    public int[] sstf(int queue[], int start) {
        int nearNum = 9999;
        visit = new int[queue.length];
        for (int i = 0; i < queue.length; i++) {
            for (int j = 0; j < queue.length; j++) {
                if (queue[j] != -1) {
                    if (Math.abs(nearNum - start) > Math.abs(queue[j] - start)) {
                        nearNum = queue[j];
                        nearIndex = j;
                    }
                }
            }
            visit[i] = nearNum;
            queue[nearIndex] = -1;
            start = nearNum;
            nearNum = 9999;
        }
        return visit;
    }

    public void print(int visit[], int start) {
        double sum = 0;
        System.out.print("Access sequence:");
        for (int i = 0; i < visit.length; i++) {
            System.out.print(visit[i] + " ");
            sum = Math.abs(visit[i] - start) + sum;
            start = visit[i];
        }
        System.out.println();
        System.out.println("Total number of tracks passed:" + sum);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the disk request sequence :");
        int a = sc.nextInt();
        System.out.println("Please enter the disk request access sequence :");
        int[] queue = new int[a];
        for (int i = 0; i < a; i++) {
            queue[i] = sc.nextInt();
        }
        SSTF sstf = new SSTF();
        System.out.println("Please enter the Head Pointer:");
        int start = sc.nextInt();
        sstf.print(sstf.sstf(queue, start), start);
    }
}
