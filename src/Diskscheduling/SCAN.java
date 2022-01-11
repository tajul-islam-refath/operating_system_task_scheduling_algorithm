package Diskscheduling;

import java.util.Scanner;

public class SCAN {

    public static void main(String[] args) {
        int ini_head, n, prev_head, trail_head;

        System.out.println("Enter initial header location: ");
        Scanner sc = new Scanner(System.in);
        ini_head = sc.nextInt();

        System.out.println("Enter previous header location: ");
        prev_head = sc.nextInt();

        System.out.println("Enter trail track location: ");
        trail_head = sc.nextInt();

        System.out.println("Enter number of disk locations: ");
        n = sc.nextInt();

        int[] disk_location = new int[n];
        int dl = 0, seek_time = 0, i, j, f = 0;

        System.out.println("Enter disk locations: ");
        for (i = 0; i < n; i++) {
            disk_location[i] = sc.nextInt();
        }

        //Arrays.sort(disk_location);
        int[] visited = new int[n + 1];

        if (prev_head <= ini_head) {
            f = 0;
        } else {
            f = 1;
        }

        for (i = 0; i < n; i++) {
            int pos = -1;
            int min = 10000;
            for (j = 0; j < n; j++) {

                if (f == 0) {

                    if (disk_location[j] > ini_head && min > Math.abs(disk_location[j] - ini_head) && visited[j] == 0) {

                        min = Math.abs(disk_location[j] - ini_head);
                        pos = j;
                    }
                } else if (f == 1) {
                    if (disk_location[j] <= ini_head && min > Math.abs(disk_location[j] - ini_head) && visited[j] == 0) {
                        
                        pos = j;
                        min = Math.abs(disk_location[j] - ini_head);
                    }
                }
            }
           
            if (pos == -1) {
                if (f == 0) {
                    f = 1;
                    seek_time += Math.abs(trail_head - ini_head);
                    
                    ini_head = trail_head;
                } else {
                    f = 0;
                    seek_time += Math.abs(0 - ini_head);
                    ini_head = 0;
                }
                
                i--;
                continue;
            }
            visited[pos] = 1;
            seek_time += Math.abs(disk_location[pos] - ini_head);
            ini_head = disk_location[pos];
        }

        System.out.println();
        System.out.println("Total Seek Time :" + seek_time);
    }
}
