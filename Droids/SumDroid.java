package Droids;

import java.util.Random;
import java.util.Scanner;

public class SumDroid extends BasicDroid{
    private int damagedone = 0;
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);

    public int Use(){
        int numb1;
        int numb2;
        int result = -1;
        numb1 = rand.nextInt(1000);
        numb2 = rand.nextInt(1000);
        result = numb1 + numb2;
        System.out.print("\n\t\tadd two numbers for a better attack\n\t\t" + numb1 + " + " + numb2 + " = ");

        int answer = scan.nextInt();
        if(answer == result){
            if(damagedone>=3000){
                damagedone = 0;
                return getDamage()*4;
            }
            damagedone += getDamage();
            return getDamage();
        }else{
            damagedone += getDamage()/2;
            return getDamage()/2;
        }
    }

    public int UseLikeBot(){
        int x = rand.nextInt(2);
        if(x==0) {
            damagedone += getDamage();
            if (damagedone >= 2000) {
                damagedone = 0;
                return getDamage() * 2;
            }
            return getDamage();
        }else {
            damagedone += getDamage() / 2;
            return getDamage() / 2;
        }
    }

    public int getDamagedone() {
        return damagedone;
    }

    @Override
    public String toString() {
        return "SumDroid{" +
                "hp=" + getHp() +
                ", damage=" + getDamage() +
                ", damagedone=" + damagedone +
                '}';
    }
}
