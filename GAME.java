
import java.util.Random;
import java.util.Scanner;

public class GAME {

    static void Rules() {
        System.out.println("\t\t======BETTING GAME RULES!======");
        System.out.println("\t1. Choose a number between 1 to 5");
        System.out.println("\t2. Winner gets all the money");
        System.out.println("\t3. Wrong guess, and you lose your bet amount");
    }

    static void bettinggame() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Enter the no of Players");
        n = sc.nextInt();
        String[] player = new String[n];
        int[] bal = new int[n];
        int[] betAmt = new int[n];
        int[] guess = new int[n];
        char chip = 10;
        int dice;
        String st = "yes";
        System.out.println("\n\t\t========WELCOME TO CASINO WORLD=======\n");
        Rules();
        for (int i = 0; i < n; i++) {
            System.out.print("\nPlayer " + (i + 1) + " Name : ");
            player[i] = sc.next();
        }
        System.out.println("\n");
        do {     // play again 
            for (int i = 0; i < n; i++) {
                System.out.print(player[i] + " enter the balance:$ ");
                bal[i] = sc.nextInt();
                sc.nextLine();
            }
            Random rand = new Random();
            do {                  //continue game
                for (int i = 0; i < n; i++) {
                    do {
                        System.out.print("\nHey, " + player[i] + ", enter amount to bet : $");
                        betAmt[i] = sc.nextInt();
                        sc.nextLine();
                        if (betAmt[i] > bal[i]) {
                            System.out.println("Betting balance can't be more than current balance!");
                            System.out.println("\nRe-enter balance\n ");
                        }
                    } while (betAmt[i] > bal[i]);
                    System.out.println(player[i] + " you got " + (betAmt[i] / chip) + " chips");
                }
                for (int i = 0; i < n; i++) {
                    do {
                        System.out.print("\n" + player[i] + " Guess any betting number between 1 to 5 :");
                        guess[i] = sc.nextInt();
                        sc.nextLine();
                        if (guess[i] <= 0 || guess[i] > 5) {
                            System.out.println("\nNumber should be between 1 to 5");
                            System.out.println("Re-enter number:\n ");
                        }
                    } while (guess[i] <= 0 || guess[i] > 5);
                }
                dice = rand.nextInt(5) + 1;  //generating Random no
                System.out.println("\n~~ The winning number was :" + dice + "~~");
                for (int i = 0; i < n; i++) {
                    if (dice == guess[i]) {
                        System.out.println("\n\t~~~" + player[i] + " CONGRATULATIONS!!!~~~~");
                        int totalWon =0;
                        for (int j = 1; j < n; j++) {
                            totalWon += betAmt[j];
                        }
                        System.out.println("\t" + player[i] + ", You have won $" + totalWon);
                        bal[i] += totalWon;
                    } else {
                        System.out.println("\n\nBetter luck next time, " + player[i]);
                        System.out.println(player[i] + ", You have lost " + betAmt[i]);
                        bal[i] -= betAmt[i];
                    }
                    System.out.println(player[i] + ", You have balance of: " + bal[i]);
                }
                for (int j = 0; j < n; j++) {
                    if (bal[j] == 0) {
                        System.out.println("\n\n" + player[j] + "  have insufficient balance");
                        System.out.println("\n\nGame will not be continued ");
                        System.out.println("THANKS FOR PLAYING");
                        return;
                    }
                }

                System.out.println("do u want to continue (yes or no)");
                st = sc.next();
            } while (st.equals("yes"));
            System.out.println("do you want to play again (yes or no)");
            st = sc.next();
        } while (st.equals("yes"));
    }

    public static void main(String[] args) {
        bettinggame();
    }
}
