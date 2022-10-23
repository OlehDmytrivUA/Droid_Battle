package Main;

import java.util.Scanner;

public class Game {
    public void StartGame(){
        Scanner scan = new Scanner(System.in);
        System.out.println( "\n\t\t---------------------------------" +
                            "\n\t\t---- Velcome to Droid Battle ----" +
                            "\n\t\t---------------------------------\n");
        int choice;
        Duel duel = new Duel();
        TeamBattle teamBattle = new TeamBattle();

        while (true) {
            System.out.print("\t\tChose Battle you want to play:\n\t\t1 - Droid Duel\n\t\t2 - Droids Team Battle\n\t\t0 - if you want to finish game\n\t\t  Choice:");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    duel.DroidDuel();
                    break;
                case 2:
                    teamBattle.TeamBattle();
                    break;
                case 0:
                    System.out.println("\t\tIt was Droid Battle \n\t\tBye bye");
                    break;
                default:
                    System.out.println("\t\tIncorect choice, try again!");
                    break;
            }
            if(choice==0){
                break;
            }
        }
    }
}
