package Droids;

import java.util.Random;
import java.util.Scanner;

public class JokerDroid extends BasicDroid{
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);
    public int Use(){
        int numb = rand.nextInt(2)+1;
        System.out.println("\n\t\tJoker want to play with you))\n\t\tGuess the number from 1 to 3 for the most damage :)");
        int Answer = scan.nextInt();
        if(Answer==numb){
            return getDamage()*2;
        }else {
            return getDamage() / 2;
        }
    }

    public int UseLikeBot(){
        int numb = rand.nextInt(2)+1;
        int Answer = rand.nextInt(2)+1;
        if(Answer==numb){
            return getDamage()*2;
        }else {
            return getDamage() / 2;
        }
    }

    @Override
    public String toString() {
        return "JokerDroid{" +
                "hp=" + getHp() +
                ", damage=" + getDamage() +
                '}';
    }
}
