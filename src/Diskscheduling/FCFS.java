
package Diskscheduling;

import java.util.Scanner;

public class FCFS {

    public static void main(String[] args) {
        int i, n, TotalHeadMovement = 0, HPointer;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Disk request:");
        n = sc.nextInt();
        int DR[] = new int[n];
        System.out.println("Enter Disk request Sequence:");
        for (i = 0; i < n; i++) {
            DR[i] = sc.nextInt();
        }
        System.out.println("Enter the Head Pointer:");
        HPointer = sc.nextInt();

        for (i = 0; i < n; i++) {
            TotalHeadMovement = TotalHeadMovement + java.lang.Math.abs(DR[i] - HPointer); //main part
            HPointer = DR[i];
        }
        System.out.println("Total Seek Distance= " + TotalHeadMovement);

    }
}
