package Main;

import Droids.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TeamBattle {
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();
    private int numbofdroids = 5;

    private int teamsize = 3;

    public void TeamBattle() {
        System.out.println("\n\n\t\tNice, Let`s start\n\n");
        int choice;
        while (true) {
            PrintMenu();
            System.out.print("\n\t\tChose what you want to do: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    StartTeamBattle();
                case 2:
                    PrintDroids();
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
                        "\t\t| 1. Start TeamBattle\n" +
                        "\t\t| 2. Show all Droid\n" +
                        "\t\t| 3. End Team Battle Game\n";

        System.out.println(Menu);
    }

    private void StartTeamBattle() {
        ArrayList<BasicDroid> Team1 = new ArrayList<BasicDroid>();
        ArrayList<BasicDroid> Team2 = new ArrayList<BasicDroid>();
        PrintDroids();
        int choice;

        for (int i = 0; i < teamsize; i++) {
            do {
                System.out.print("\t\tChose " + (i+1) + " droid:");
                while (!scan.hasNextInt()) {
                    System.out.println("That not a number!");
                    scan.next(); // this is important!
                }
                choice = scan.nextInt();
                if(choice<=0 || choice>numbofdroids){
                    System.out.println("Try again");
                }else{
                    break;
                }
            } while (true);

            switch (choice) {
                case 1:
                    Team1.add(new SumDroid());
                    break;
                case 2:
                    Team1.add(new SubDroid());
                    break;
                case 3:
                    Team1.add(new JokerDroid());
                    break;
                case 4:
                    Team1.add(new DivideDroid());
                    break;
                case 5:
                    Team1.add(new MultiplyDroid());
                    break;
            }
        }

        for (int i = 0; i < teamsize; i++) {
            choice = rand.nextInt(numbofdroids - 1) + 1;
            switch (choice) {
                case 1:
                    Team2.add(new SumDroid());
                    break;
                case 2:
                    Team2.add(new SubDroid());
                    break;
                case 3:
                    Team2.add(new JokerDroid());
                    break;
                case 4:
                    Team2.add(new DivideDroid());
                    break;
                case 5:
                    Team2.add(new MultiplyDroid());
                    break;
            }
        }
        startBattle(Team1,Team2);

    }

    private void PrintDroids(){
        String Droids = "\n\t\t---------------------------------------------------------------------------\n" +
                "\t\t---------------------------- | Droids | -----------------------------------\n" +
                "\t\t---------------------------------------------------------------------------\n" +
                "\t\t| 1. SumDroid (add two numbers for a better attack , after 3000 damagedone\n" +
                "\t\t| atack wil be incredible -- 4000 )----------------------------------------\n" +
                "\t\t| 2. SubDroid (Subtract two numbers for a better atack and hprecovery(+500)\n" +
                "\t\t| 3. JokerDroid (Guess the number from 1 to 3 for the most damage :)-------\n" +
                "\t\t| 4. DivideDroid (Divide two numbers for a better attack)------------------\n" +
                "\t\t| 5. MultiplyDroid (multiply two numbers for a better attack , every corect\n" +
                "\t\t| answer increase your damage (1000 + 100*CorectAnswers) ------------------\n";
        System.out.println(Droids);
    }

    private void startBattle(ArrayList<BasicDroid> team1,ArrayList<BasicDroid> team2){
        int temphp;
        int tempdamage;
        int droidForAttack;
        int opponent;
        while(team1.size()>0 && team2.size()>0){
            StatusOfBattle(team1,team2);

            do {
                System.out.print("\t\tChose droid you want to use(1,2..):");
                while (!scan.hasNextInt()) {
                    System.out.println("That not a number!");
                    scan.next(); // this is important!
                }
                droidForAttack = scan.nextInt();
                if(droidForAttack<=0 || droidForAttack>team1.size()){
                    System.out.println("Try again");
                }else{
                    break;
                }
            } while (true);

            do {
                System.out.print("\t\tChose droid you want to attack(1,2..):");
                while (!scan.hasNextInt()) {
                    System.out.println("That not a number!");
                    scan.next(); // this is important!
                }
                opponent = scan.nextInt();
                if(opponent<=0 || opponent>team2.size()){
                    System.out.println("Try again");
                }else{
                    break;
                }
            } while (true);

            temphp = team2.get(opponent-1).getHp();
            temphp -= team1.get(droidForAttack-1).Use();
            System.out.println("\t\tYou took damage -- " + (team2.get(opponent-1).getHp() - temphp));
            team2.get(opponent-1).setHp(temphp);
            if(temphp<=0) {
                team2.remove(opponent - 1);
            }


            if(team2.size()==1){
                droidForAttack = 0;
            }else {
                droidForAttack = rand.nextInt(team2.size() - 1) + 1;
            }
            if(team1.size()==1){
                opponent = 0;
            }else {
                opponent = rand.nextInt(team1.size() - 1) + 1;
            }
            temphp = team1.get(opponent).getHp();
            temphp -= team2.get(droidForAttack).UseLikeBot();
            System.out.println("\t\tYour oponent took damage -- " + (team1.get(opponent).getHp() - temphp) + "\n\t\tto" + team1.get(opponent) + "\n");
            team1.get(opponent).setHp(temphp);
            if(temphp<=0){
                team1.remove(opponent);
            }
        }
        if(team1.size()>0){
            System.out.println( "\n\t\t---------------------------------------------" +
                                "\n\t\t---- Congratulations , you are winner!!! ----");
        }else if(team2.size()>0){
            System.out.println("You lost((");
        }else{
            System.out.println( "\n\t\t--------------------------------" +
                                "\n\t\t------- Played in a draw -------" +
                                "\n\t\t----- You are both winners -----");
        }
    }

    private void StatusOfBattle(ArrayList<BasicDroid> team1,ArrayList<BasicDroid> team2){
        System.out.println("\t\t---------------------------------------------------------\n" +
                           "\t\t------------------|STATUS OF BATTLE|---------------------");
        System.out.println("\t\t///Team1///");
        for (int i = 0; i < teamsize; i++) {
            System.out.print("\t\t");
            if(i< team1.size()) {
                System.out.println(i + 1 + ". " + team1.get(i));
            }else{
                System.out.println(i+1+"(x_x)");
            }
        }
        System.out.println("\t\t///Team2///");
        for (int i = 0; i < teamsize; i++) {
            System.out.print("\t\t");
            if(i < team2.size()) {
                System.out.println(i + 1 + ". " + team2.get(i));
            }else{
                System.out.println(i+1+"(x_x)");
            }
        }
    }
}
