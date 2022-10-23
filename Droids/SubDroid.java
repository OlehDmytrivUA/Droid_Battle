package Droids;

import java.util.Random;
import java.util.Scanner;

public class SubDroid extends BasicDroid{
    private int hpRecovery = 500;
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);

    public int Use(){
        int numb1;
        int numb2;
        int result = -1;
        numb1 = rand.nextInt(1000);
        numb2 = rand.nextInt(1000);
        if(numb1>numb2){
            result = numb1 - numb2;
            System.out.print("\n\t\tSubtract two numbers for a better attack\n\t\t" + numb1 + " - " + numb2 + " = ");
        }else{
            result = numb2 - numb1;
            System.out.print("\n\t\tSubtract two numbers for a better attack\n\t\t" + numb2 + " - " + numb1 + " = ");
        }
        int answer = scan.nextInt();
        if(answer == result){
            int temp = getHp();
            setHp(temp+hpRecovery);
            return getDamage()+hpRecovery;
        }else{
            return getDamage();
        }
    }

    public int UseLikeBot(){
        int x = rand.nextInt(2) +1;
        if(x==1) {
            int temp = getHp();
            setHp(temp+hpRecovery);
            return getDamage()+hpRecovery;
        }else {
            return getDamage();
        }
    }

    @Override
    public String toString() {
        return "SubDroid{" +
                "hp=" + getHp() +
                ", damage=" + getDamage() +
                '}';
    }
}
