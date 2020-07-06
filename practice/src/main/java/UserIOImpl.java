
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
public class UserIOImpl implements UserIO{

    Scanner scanner = new Scanner(System.in);
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return (scanner.nextLine());
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return (Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int input;
        do{
            input = readInt(prompt);
        }
        while(!(min<=input && input<=max));
        return input;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double input;
        do{
            System.out.println(prompt);
            input = Double.parseDouble(scanner.nextLine());
        }while(!(min<=input && input<=max));
        return input;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return (Float.parseFloat(scanner.nextLine()));
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float input;
        do{
            input=readFloat(prompt);
        }while(!(min<=input && input<=max));
        return input;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return (Long.parseLong(scanner.nextLine()));
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long input;
        do{
            input = readLong(prompt);
        }while(!(min<=input && input<=max));
        return input;
    }
    
}
