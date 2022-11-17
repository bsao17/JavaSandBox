package com.mehddeb;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjour taper 1 pour commencer à jouer et 1 à la fin de chaque partie pour continuer !");
        byte playing = scanner.nextByte();
        System.out.println("**** Pour choisir le Chronométre tapez le numéro 1 ****");
        System.out.println("**** Pour choisir la calculatrice tapez le numéro 2 ****");
        System.out.println("**** Pour lancer un dè après 2 secondes tapez le numéro 3 ****");
        System.out.println("**** C'est à vous : ");

        while(playing == 1){

            int choice = scanner.nextInt();

            if(choice == 1)
            {
                System.out.println("Veuillez choisir la durée du décompte en secondes !");
                CustomTimer customTimer = new CustomTimer();
                CustomTimer.time = scanner.nextInt();
                Timer timer = new Timer();
                timer.schedule(customTimer, 1000, 1000);
            }
            if (choice == 2)
            {
                System.out.println("Veuillez choisir les chiffres à soustraire !");
                substract(scanner.nextInt(), scanner.nextInt(), new CalculListener() {
                    @Override
                    public void onPositiveResult() {
                        System.out.println("Le résultat est positif !");
                    }

                    @Override
                    public void onNegativeResult() {
                        System.out.println("Le résultat est négatif !");
                    }
                });
            }
            if(choice == 3) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    int time = 2;
                    @Override
                    public void run() {
                        if (time != 0){
                            System.out.println( time + " secondes ");
                        } else {
                            nexInt(1, 6);
                            cancel();
                        }
                        time--;
                    }

                }, 1000, 1000);
            }
            if (choice == 0){
                System.exit(1);
            }
        }



    }

    public static void nexInt(int a, int b){
        Random random = new Random();
        System.out.println("Le résultat du lancé de dès est ...");
        System.out.println(random.nextInt(a, b));
    }

    private static void substract(int a, int b, CalculListener calculListener) {
        int result = a - b;
        if(result >= 0){
            calculListener.onPositiveResult();
        } else {
            calculListener.onNegativeResult();
        }
    }
}
