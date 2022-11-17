package com.mehddeb;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**** Pour choisir le Chronométre tapez le numéro 1 ****");
        System.out.println("**** Pour choisir la calculatrice tapez le numéro 2 ****");
        System.out.println("**** Pour lancer un dè après 2 secondes tapez le numéro 3 ****");
        System.out.println("**** C'est à vous : ");

        while(true){
            int choice = scanner.nextInt();

            if(choice == 1)
            {
                System.out.println("Veuillez choisir la durée du décompte en secondes !");
                CustomTimer customTimer = new CustomTimer();
                CustomTimer.time = scanner.nextInt();
                Timer timer = new Timer();
                timer.schedule(customTimer, 1000, 1000);
                System.out.println("Choisissez votre activité !");
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
                System.out.println("Choisissez votre activité !");
            } else {
                System.out.println("Choisissez votre activité !");
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
                            System.out.println("Choisissez votre activité !");
                            cancel();
                        }
                        time--;
                    }

                }, 1000, 1000);
                System.out.println("Choisissez votre activité !");
            }

            if (choice == 0){
                List<Integer> counter = new ArrayList<>(){};
                counter.add(3);
                counter.add(6);
                counter.add(9);
                counter.forEach(System.out::println);
                Runnable GoodBye = (() -> System.out.println("Goobbye, See you later ..."));
                GoodBye.run();
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
