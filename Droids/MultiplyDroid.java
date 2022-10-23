package Droids;

import java.util.Random;
import java.util.Scanner;

public class MultiplyDroid extends BasicDroid{

    private int corectanswers = 0;
    private int corectanswersbot = 0;
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);

    public int Use(){
        int numb1;
        int numb2;
        int result = -1;
        numb1 = rand.nextInt(100);
        numb2 = rand.nextInt(10);
        result = numb1 * numb2;
        System.out.print("\n\t\tMultiply two numbers for a better attack\n\t\t" + numb1 + " * " + numb2 + " = ");

        int answer = scan.nextInt();
        if(answer == result){
            corectanswers++;
            return getDamage()+(100*corectanswers);
        }else{
            corectanswers = 0;
            return getDamage();
        }
    }

    public int UseLikeBot(){
        int x = rand.nextInt(1);
        if(x==1) {
            corectanswersbot++;
            return getDamage()+(100*corectanswersbot);
        }else {
            corectanswersbot = 0;
            return getDamage();
        }
    }

    @Override
    public String toString() {
        return "MultiplyDroid{" +
                "hp=" + getHp() +
                ", damage=" + getDamage() + "*(corectanswers)" +
                ", corectanswers=" + corectanswers +
                '}';
    }
}
