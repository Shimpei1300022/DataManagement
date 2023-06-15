import java.util.Random;
import java.util.Scanner;

class DiceGame{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        System.out.print("> ");
        String name = sc.next();
        System.out.println("Hello, " + name + "!");
        Random rnd = new Random();
        System.out.println("Rolling dice...");

        int x = rnd.nextInt(6) + 1;
        System.out.println("Die 1: " + x);
        
        int y = rnd.nextInt(6) + 1;
        System.out.println("Die 2: " + y);

        System.out.println("Total value: " + (x+y));
        if(x+y > 7)System.out.println("You won");
        else System.out.println("You lost");
    }
}