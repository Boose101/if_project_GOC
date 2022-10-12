import java.util.Scanner;
import java.util.Random;
public class gameofchance {
    private static Random random = new Random();
    private static String [] game_names = {"dice", "coins", "spinner"};
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        final boolean dev = false;
        boolean games [] = {false, false, false};

        System.out.println("This is the game of chance!");
        System.out.println("Lets see if you won..." + '\n');

        System.out.println("Whats your guess on the dice roll?");

        int roll = random.nextInt(6)+1;

        int user_roll = scan.nextInt();

        if(roll == user_roll){games[0]=true;}

        System.out.println("What is your guess on the coin flip, Heads (H) or Tails (T)?");

        boolean ai_flip = random.nextBoolean(); //ai true = heads

        String op[] = {"Heads", "Tails"};

        scan.nextLine();

        String user_flip = scan.nextLine();

        user_flip = user_flip.toUpperCase();

        int uf;

        if(user_flip.equals("H")){
            uf = 0;
        }else{
            uf = 1;
        }

        if(user_flip.equals("H") && ai_flip){games[1]=true;}
        else if(user_flip.equals("T") && !ai_flip){games[1]=true;}


        System.out.println("What is your guess on the spinner, red (r), green (g), blue (b), or yellow (y)?");

        String[] colors = {"r", "g", "b", "y"};
        String[] colors_act = {"red", "green", "blue", "yellow"};

        int ai_spin = random.nextInt(4);

        String user_spin = scan.nextLine();

        user_spin = user_spin.toLowerCase();

        int us = 0;

        for(int x = 0; colors.length > x; x++){
            if(user_spin.equals(colors[x])){
                us = x;
            }
        }

        if(colors[ai_spin].equals(user_spin)){games[2]=true;}

        System.out.println("You rolled a " + user_roll + "." + '\n' +
        "You flipped an " + op[uf] + "." + '\n' +
        "You spun " + colors_act[us] + ".");

        if(dev){
            System.out.println("You rolled a " + roll + "." + '\n' +
        "You flipped an " + ai_flip + "." + '\n' +
        "You spun " + colors_act[ai_spin] + ".");
        }


        if(allTrue(games)){
            System.out.println("You managed to get everything correct");
        }else if(allFalse(games)){
            System.out.println("You manged to get everything wrong");
        }else if(games[0]){
            if(games[1]){
                System.out.println("You got the " + game_names[0] + " and " + game_names[1] + " correct.");
            }else{
                System.out.println("You got the " + game_names[0] + " correct.");
            }
        }else if (games[1]){
            if(games[2]){
                System.out.println("You got the " + game_names[1] + " and " + game_names[2] + " correct.");
            }else{
                System.out.println("You got the " + game_names[1] + " correct.");
            }
        }else{
            System.out.println("You got the " + game_names[2] + " correct.");
        }
       
        

    }

    private static boolean allTrue (boolean[] values) {
        for (boolean value : values) {
            if (!value)
                return false;
        }
        return true;
    }
    private static boolean allFalse (boolean[] values) {
        for (boolean value : values) {
            if (value)
                return false;
        }
        return true;
    }
}