
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minsikkim
 */
public class BowlingScores {
    List <Integer[]> frames;
    public BowlingScores(){
        this.frames = new ArrayList<Integer[]>();
    }
    public void add(Integer[] frame){
        frames.add(frame);
    }
    public int calcScore(){
        int total = 0;
        int currentBall = 1;
        int nextBall = 0;
        int nextNextBall = 0;
        int scoreInFrame=0;
        boolean firstBall = true;
        for (Integer[] frame : frames){
            firstBall=true;
            scoreInFrame=0;
            //if it is not the last frame
            if (frame.length  ==2){
                System.out.println("This frames has "+frame[0]+", "+frame[1]);
                for (int i : frame){
                    if (i==10){
                        if (firstBall){
                            System.out.println("STRIKE!!!");
                            nextBall+=1;
                            nextNextBall+=1;
                            total+=(currentBall*i);
                            System.out.println((currentBall*i)+"  Added!!");
                            currentBall=nextBall+1;
                            nextBall=nextNextBall;
                            nextNextBall=0;
                            break;
                            
                        }
                        else{
                            System.out.println("SPARE!!!");
                            nextBall+=1;
                        }
                        
                    }else {
                        firstBall=false;
                        scoreInFrame+=i;
                        if (scoreInFrame==10){
                            System.out.println("SPARE!!!");
                            nextBall+=1;
                        }else{
                            System.out.println("haha");
                        }
                    }
                    total+=(currentBall*i);
                    System.out.println((currentBall*i)+"  Added!!");
                    currentBall=nextBall+1;
                    nextBall=nextNextBall;
                    nextNextBall=0;
                }
            }else{
                //The last frame
                for (int i : frame){
                    total+=(currentBall*i);
                    System.out.println((currentBall*i)+"  Added!!");
                    currentBall=nextBall+1;
                    nextBall=nextNextBall;
                    nextNextBall=0;
                }
            }
            
            
        }
        System.out.println("Score is : "+total);
        return total;
    }
    public static void main(String[] args) {
        BowlingScores frames = new BowlingScores();
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{8, 0, 0}); //80
        frames.calcScore();

        frames = new BowlingScores();
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 0});
        frames.add(new Integer[] {10, 10, 10});  //300
        frames.calcScore();

        frames = new BowlingScores();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 0});
        frames.add(new Integer[]{9, 1}); //36
        frames.calcScore();

        frames = new BowlingScores();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2}); //82
        frames.calcScore();

        frames = new BowlingScores();
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{8, 1});
        frames.add(new Integer[]{9, 0});
        frames.add(new Integer[]{7, 3});
        frames.add(new Integer[]{6, 3});
        frames.add(new Integer[]{8, 2, 5}); //173
        frames.calcScore();
    }
}
