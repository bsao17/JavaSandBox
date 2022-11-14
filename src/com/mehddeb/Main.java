package com.mehddeb;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        System.out.println("Veuillez choisir 1 pour utiliser le Chronomètre et 2 pour la soustraction !");
        Scanner scanner = new Scanner(System.in);
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
