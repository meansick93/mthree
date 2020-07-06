
import java.util.Random;
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
public class LuckySeven {
    final static int DICE = 6;
    public static void main(String[] args){
        LuckySeven ls = new LuckySeven();
        ls.start();
        
    }
    public void start(){
        int currValue = 0;
        int maxValue = 0;
        int maxRolls = 0;
        int numRolls = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many dollars do you have?");
        currValue = sc.nextInt(); sc.nextLine();
        while (currValue>0){
            numRolls++;
            if (rollTheDice()){
                currValue+=4;
                if (currValue>maxValue){
                    maxValue = currValue;
                    maxRolls = numRolls;
                }
            }else{
                currValue-=1;
            }
        }
        System.out.println("You are broke after "+numRolls+" rolls.");
        System.out.println("You should have quit after "+maxRolls+" when you had $"+maxValue+".");
    }
    public static boolean rollTheDice(){
        Random random = new Random();
        int dice1 = random.nextInt(DICE)+1;
        int dice2 = random.nextInt(DICE)+1;
        
        return ((dice1+dice2)==7);
    }
}
