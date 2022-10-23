package Main;

import java.util.Random;

import Droids.*;

import java.util.Scanner;

public class Duel {
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();
    private int numbofdroids = 5;

    public void DroidDuel() {
        System.out.println("\n\n\t\tNice, Let`s start\n\n");
        int choice;
        while (true) {
            PrintMenu();
            System.out.print("\t\t\tChose what you want to do: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    StartDroidsDuel();
                    break;
                case 2:
                    PrintDroids();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\t\tTry Again");
            }
        }

    }

    private void PrintMenu() {
        String Menu =   "\t\t-------------------------------------------------------------------\n" +
                        "\t\t---------------------------- | MENU | -----------------------------\n" +
                        "\t\t-------------------------------------------------------------------\n" +
                        "\t\t| 1. Start Duel\n" +
                        "\t\t| 2. Show all Droid\n" +
                        "\t\t| 3. End Duel Game\n";

        System.out.println(Menu);
    }

    private void StartDroidsDuel() {
        BasicDroid Droid_1 = new BasicDroid();
        BasicDroid Droid_2 = new BasicDroid();
        PrintDroids();
        System.out.print("Chose your droid:");
        int choice;
        while (true) {
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Droid_1 = new SumDroid();
                    break;
                case 2:
                    Droid_1 = new SubDroid();
                    break;
                case 3:
                    Droid_1 = new JokerDroid();
                    break;
                case 4:
                    Droid_1 = new DivideDroid();
                    break;
                case 5:
                    Droid_1 = new MultiplyDroid();
                    break;
                default:
                    System.out.println("Incorrect choice, try again!");
            }
            if(choice>=1 && choice<=5 ){
                break;
            }
        }
        choice = rand.nextInt(numbofdroids-1)+1;
        switch (choice) {
            case 1:
                Droid_2 = new SumDroid();
                break;
            case 2:
                Droid_2 = new SubDroid();
                break;
            case 3:
                Droid_2 = new JokerDroid();
                break;
            case 4:
                Droid_1 = new DivideDroid();
                break;
            case 5:
                Droid_1 = new MultiplyDroid();
                break;
        }
        startBattle(Droid_1,Droid_2);

    }

    private void PrintDroids(){
        String Droids = "\n\t\t---------------------------------------------------------------------------\n" +
                        "\t\t---------------------------- | Droids | -----------------------------------\n" +
                        "\t\t---------------------------------------------------------------------------\n" +
                        "\t\t| 1. + SumDroid (add two numbers for a better attack , after 3000 damagedone\n" +
                        "\t\t| atack wil be incredible -- 4000 )\n" +
                        "\t\t| 2. - SubDroid (Subtract two numbers for a better atack and hprecovery(+500)\n" +
                        "\t\t| 3. ? JokerDroid (Guess the number from 1 to 3 for the most damage :)\n" +
                        "\t\t| 4. / DivideDroid (Divide two numbers for a better attack(only int part of result)\n" +
                        "\t\t| 5. * MultiplyDroid (multiply two numbers for a better attack , every corect\n" +
                        "\t\t| answer increase your damage (1000 + 100*CorectAnswers)\n";
        System.out.println(Droids);
    }

    private void startBattle(BasicDroid Droid, BasicDroid bot){
        int temphp;
        while(Droid.IsAlive() && bot.IsAlive()){
            temphp = bot.getHp();
            temphp -= Droid.Use();
            System.out.println("\n\t\tYou took damage -- " + (bot.getHp() - temphp));
            bot.setHp(temphp);

            temphp = Droid.getHp();
            temphp -= bot.UseLikeBot();
            System.out.println("\n\t\tYour oponent took damage -- " + (Droid.getHp() - temphp));
            Droid.setHp(temphp);
            System.out.println("\t\t------------------------------------------");
            System.out.println("\t\t" + Droid);
            System.out.println("\t\t" + bot);
        }
        if(Droid.IsAlive()){
            System.out.println( "\n\t\t---------------------------------------------" +
                                "\n\t\t---- Congratulations , you are winner!!! ----");
        }else if(bot.IsAlive()){
            System.out.println("\n\t\tYou lost((");
        }else{
            System.out.println( "\n\t\t--------------------------------" +
                                "\n\t\t------- Played in a draw -------" +
                                "\n\t\t----- You are both winners -----");
        }
    }


}


