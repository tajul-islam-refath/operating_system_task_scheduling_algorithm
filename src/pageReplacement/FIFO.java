package pageReplacement;

import java.util.Scanner;

public class FIFO {

    public static void main(String args[]) {
        int pageRef , totalFrame , Hit = 0, Fault = 0, j=0;
        float HRatio , FRatio;
        boolean check;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Total Page Referance : ");
        pageRef = sc.nextInt();
        int inp[] = new int[pageRef];
        
        System.out.println("Total Fream : ");
        totalFrame = sc.nextInt();
        int frame[] = new int[totalFrame];
        
        System.out.println("Enter Value of page ref : ");
        for(int i=0; i<pageRef; i++){
            inp[i] = sc.nextInt();
        }
        
        for (int i = 0; i <totalFrame; i++) {
            frame[i] = -1;
        }
        
        
        for(int i=0; i<pageRef; i++){
            check = false;
            for(int k = 0; k<totalFrame; k++){
                if(frame[k] == inp[i]){
                    Hit++;
                    check = true;                  
                }
            }
            
            if(check == false){
                frame[j] = inp[i];
                j++;
                if(j >= totalFrame){
                    j = 0;
                }
            }
                     
        }
        
        HRatio = (float) Hit / (float) pageRef;
        FRatio = 1 - HRatio;
        Fault = pageRef - Hit;
        System.out.println("Total Hit "+Hit+"\n Total Fault "+Fault);
        System.out.println("Hit ratio= " + HRatio + "\n" + "Fault ratio: " + FRatio);
        

    }
}
