import java.util.Scanner;
import java.util.Random;
public class Gameofchance {
    private static boolean games [] = {false, false, false};

    private static Random random = new Random();

    private static String [] game_names = {"dice", "coins", "spinner"};
    private static String coin_options[] = {"Heads", "Tails"};
    private static String[] colors_act = {"red", "green", "blue", "yellow"};
    
    private final boolean dev = false; //Testing

    public static void main(String[] args) {
        
        Inputs.getScanner();

        System.out.println("This is the game of chance!");
        System.out.println("Lets see if you won..." + '\n');

        int user_roll = dice();

        int user_flip = coin_flip();


       int user_spin = spinner();

        System.out.println("You rolled a " + user_roll + "." + '\n' +
        "You flipped an " + coin_options[user_flip] + "." + '\n' +
        "You spun " + colors_act[us] + ".");




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
       
        
        scan.close();
    }

    public static int dice(){
        System.out.println("Whats your guess on the dice roll?");

        int roll = random.nextInt(6)+1;

        int user_roll = scan.nextInt();

        scan.nextLine();

        if(roll == user_roll){games[0]=true;}
        return roll;
    }

    public static int coin_flip(){
        System.out.println("What is your guess on the coin flip, Heads (H) or Tails (T)?");

        boolean ai_flip = random.nextBoolean(); //ai true = heads


        scan.nextLine();

        String user_flip = scan.nextLine();

        user_flip = user_flip.toUpperCase();

        int uf;

        if(user_flip.equals("H")){
            uf = 0;
        }else{
            uf = 1;
        }

        if(user_flip.equals("H") && ai_flip){
            games[1]=true;
        }
        else if(user_flip.equals("T") && !ai_flip){
            games[1]=true;
        }

        return uf;
    }

    public static int spinner(){
        System.out.println("What is your guess on the spinner, red (r), green (g), blue (b), or yellow (y)?");

        String[] colors = {"r", "g", "b", "y"};
        

        int ai_spin = random.nextInt(4);

        String user_spin = scan.nextLine();

        user_spin = user_spin.toLowerCase();

        int us = 0;

        for(int x = 0; colors.length > x; x++){
            if(user_spin.equals(colors[x])){
                us = x;
            }
        }

        if(colors[ai_spin].equals(user_spin)){
            games[2]=true;
        }

        return us;
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