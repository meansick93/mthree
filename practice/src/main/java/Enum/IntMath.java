/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

import java.util.Scanner;

/**
 *
 * @author minsikkim
 */
public class IntMath {
    public static void main(String[] args) {
        int firstNum=0;
        int secondNum=0;
        UserIO io = new UserIOImpl();
        io.print("WELCOME!");
        while (true){
            io.print("1 : plus, 2 : minus, 3 : mul, 4 : divide");
            int in = io.readInt("Enter menu",1,4);
            switch(in){
                case 1:
                    firstNum = io.readInt("enter first number");
                    secondNum = io.readInt("enter second number");
                    //System.out.println("the result is : "+);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    io.print("please choose again");
            }
        }
        
    }
   public int calculate(MathOperators operator, int operand1, int operand2) {
         switch(operator) {
                case PLUS:
                      return operand1 + operand2;
                case MINUS:
                      return operand1 - operand2;
                case MULTIPLY:
                      return operand1 * operand2;
                case DIVIDE:
                      return operand1 / operand2;
                default:
                      throw new UnsupportedOperationException();
         }
   }
}