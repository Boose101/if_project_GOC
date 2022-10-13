import java.util.Scanner;
import java.util.Random;
public class Gameofchance {
    private static boolean games [] = {false, false, false};

    private static Random random = new Random();

    private static String [] game_names = {"dice", "coins", "spinner"};
    private static String coin_options[] = {"Heads", "Tails"};
    private static String[] colors_act = {"red", "green", "blue", "yellow"};

    private static double money = 0;
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        while(true){
            start(scan);
        }
       
    }

    public static void start(Scanner scan){
        System.out.println("*****WELCOME*****");
        
        int money_choice = 1;
        double bet = 0;
        while(money_choice == 1){
            System.out.println("You have $" + money + " in the bank");

            System.out.println("Please choose one of the following options:" + "\n" +
            "   (1) Deposit money into the bank " + "\n" +
            "   (2) Play the game!" + "\n" + 
            "   (3) Quit the game.");

            money_choice = scan.nextInt();


            scan.nextLine(); 

            if(money_choice == 1){
                System.out.println("How much would you like to deposit?");
                double deposit = scan.nextDouble();
                
                money += deposit;
            }
        }
        if(money_choice == 2){
            bet = betting(scan);
            money -= bet;
        }else{
            System.exit(0);
        }
        game(scan);
        results(bet);

    }

    public static void game(Scanner scan){
        int user_roll = dice(scan);

        int user_flip = coin_flip(scan);


       int user_spin = spinner(scan);

        System.out.println("You rolled a " + user_roll + "." + '\n' +
            "You flipped an " + coin_options[user_flip] + "." + '\n' +
            "You spun " + colors_act[user_spin] + ".");

        
    }

    public static void results(double bet){
        if(allTrue(games)){
            System.out.println("You managed to get everything correct");
            money += bet*3;
        }else if(allFalse(games)){
            System.out.println("You manged to get everything wrong");
        }else if(games[0]){
            if(games[1]){
                System.out.println("You got the " + game_names[0] + " and " + game_names[1] + " correct.");
                money += bet*2;
            }else{
                System.out.println("You got the " + game_names[0] + " correct.");
                money += bet;
            }
        }else if (games[1]){
            if(games[2]){
                System.out.println("You got the " + game_names[1] + " and " + game_names[2] + " correct.");
                money += bet*2;
            }else{
                System.out.println("You got the " + game_names[1] + " correct.");
                money += bet/4;
            }
        }else{
            System.out.println("You got the " + game_names[2] + " correct.");
            money += bet/2;
        }
    }

    public static double betting(Scanner scan){
        System.out.println("How much would you like to bet?");
        double bet = scan.nextDouble();

        boolean clerance = false;

        while(!clerance){
            if(bet > 0 && bet <= money){
                clerance = true;
            }else{
                System.out.println("Please enter an amount lower than $" + money);
            }
        }
        return bet;
    }

    public static int dice(Scanner scan){
        
        System.out.println("Whats your guess on the dice roll?");

        int roll = random.nextInt(6)+1;

        int user_roll = scan.nextInt();

        if(roll == user_roll){games[0]=true;}
        return roll;
    }

    public static int coin_flip(Scanner scan){
        System.out.println("What is your guess on the coin flip, Heads (H) or Tails (T)?");

        boolean ai_flip = random.nextBoolean(); //ai true = heads

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

    public static int spinner(Scanner scan){
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