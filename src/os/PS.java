
package os;

import java.util.Arrays;
import java.util.Scanner;


public class PS {
      
    private static int n;
    private static int process[];
    private static int bt[];
    private static int at[];
    private static int ct[];
    private static int tat[];
    private static int wt[];
    private static double avg = 0;
    private static double totalTat = 0;
    
    static void compleatingTime() {
        ct = new int[n];
        int arr[] = at.clone();
        
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == at[j]) {
                    sum += bt[j];
                    ct[j] = sum;
                }
            }
        }

    }

    static void calculateTat() {
        tat = new int[n];
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - 0;
            totalTat += tat[i];
        }
    }

    static void calculateWt() {
        wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            avg += wt[i];
        }
    }

    static void print() {
       
        for(int i=0; i<n; i++){
            System.out.println(process[i]+" "+ at[i]+" "+bt[i]+ " "+ct[i]+" "+tat[i]+" "+wt[i]);
        }
        
        System.out.println("Total TAT "+ totalTat);
        System.out.println("Average TAT : " + (totalTat / n));
        System.out.println("Waiting Time "+ avg);
        System.out.println("Average waiting time " + (avg / n));
      
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter total process : ");
        n = sc.nextInt();

        process = new int[n];
        bt = new int[n];
        at = new int[n];

        System.out.println("Enter process NO : ");
        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
        }
        
        System.out.println("Enter bust time");

        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }
        
        System.out.println("Enter Priority Scheduling : ");

        for (int i = 0; i < n; i++) {
            at[i] = sc.nextInt();
        }

        compleatingTime();
        calculateTat();
        calculateWt();
        print();
    }
}
