package ibikunle.tolani;

import java.util.Scanner;

/**
 * Created by tolaniibikunle on 1/27/17.
 */
public class Casino {
    BlackJack blackJack = new BlackJack();
    GoFish gofish = new GoFish();
    public void helloMessage(){
        System.out.println("Welcome to Tolani's Casino!");
        System.out.println("What is your name ?");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        System.out.println("Hello "+ name);
        System.out.println("Would you like to play BlackJack or GoFish?");

        String gameToPlay = in.nextLine();
        if(gameToPlay.equals("BlackJack")){

        } else if(gameToPlay.toLowerCase().equals("gofish")){
            gofish.startGame();
        }
    }

    // Welcome to Tolani's Casino
    // Which game would you like to play BlackJack or Go Fish?
    // then move towards the whichever game you picked
}
