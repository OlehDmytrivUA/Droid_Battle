package Droids;

import java.util.Random;
import java.util.Scanner;

public class DivideDroid extends BasicDroid{
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);

    public int Use(){
        int numb1;
        int numb2;
        int result = -1;
        numb1 = rand.nextInt(100)+20;
        numb2 = rand.nextInt(10);
        result = numb1 / numb2;
        System.out.print("\n\t\tDivide two numbers for a better attack\n\t\t" + numb1 + " / " + numb2 + " = ");

        int answer = scan.nextInt();
        if(answer == result){
            return getDamage()*2;
        }else{
            return getDamage();
        }
    }

    public int UseLikeBot(){
        int x = rand.nextInt(2) +1;
        if(x==1) {
            return getDamage()*2;
        }else {
             return getDamage();
        }
    }

    @Override
    public String toString() {
        return "DivideDroid{" +
                "hp=" + getHp() +
                ", damage=" + getDamage() +
                '}';
    }
}
