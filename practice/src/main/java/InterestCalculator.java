
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minsikkim
 */
public class InterestCalculator {
    public static void main(String[] args) {
        float endValue = 0;
        float currValue=0;
        int years=0;
        float interestRate=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("How much do you want to invest?");
        currValue = sc.nextFloat();sc.nextLine();
        System.out.println("How many years are you investing?");
        years = sc.nextInt(); sc.nextLine();
        System.out.println("What is the annual interest rate?");
        interestRate = sc.nextFloat(); sc.nextLine();
        
        /*********Printinggg*******/
        System.out.println("Calculating...");
        for (int i=1;i<=years;i++){
            endValue = currValue;
            System.out.println("Year "+i+" :");
            System.out.println("Began with $"+String.format("%.2f", endValue));
            for (int j=0;j<4;j++){
                currValue*=(1+interestRate/400);
            }
            System.out.println("Earned $"+String.format("%.2f",(currValue-endValue)));
            System.out.println("Ended with $"+String.format("%.2f", currValue));
            System.out.println("");
            System.out.println("");
        }
        
    }
}
